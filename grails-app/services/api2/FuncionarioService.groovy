package api2

import grails.gorm.transactions.Transactional
import grails.web.api.ServletAttributes

@Transactional
class FuncionarioService implements ServletAttributes {

    Map save() {
        Map retorno = [success: true]

        Funcionario funcionario = new Funcionario()
        funcionario.setNome(request.JSON.nome)

        if (funcionario.hasErrors()) {
            retorno.success = false
            retorno.errors = funcionario.getErrors()
            return retorno
        }

        funcionario.save(flush: true)

        retorno.registro = funcionario

        return retorno
    }
}
