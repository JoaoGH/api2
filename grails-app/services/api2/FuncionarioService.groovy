package api2

import grails.gorm.transactions.Transactional
import grails.web.api.ServletAttributes

@Transactional
class FuncionarioService implements ServletAttributes {

    Map save() {
        Map retorno = [success: true]

        Funcionario funcionario = new Funcionario()
        funcionario.setNome(request.JSON.nome)

        if (!funcionario.validate()) {
            retorno.success = false
            retorno.errors = funcionario.getErrors()
            return retorno
        }

        funcionario.save(flush: true)

        retorno.registro = funcionario

        return retorno
    }

    Map list() {
        Map retorno = [success: true]

        List<Funcionario> funcionarioList = Funcionario.createCriteria().list {}

        retorno.total = funcionarioList.size()
        retorno.registro = funcionarioList

        return retorno
    }

    Map update() {
        Map retorno = [success: true]

        Funcionario funcionario = Funcionario.createCriteria().get {
            idEq(params.id as Long)
        }

        funcionario.setNome(request.JSON.nome)
        funcionario.save(flush: true)

        retorno.registro = funcionario

        return retorno
    }

    Map delete() {
        Map retorno = [success: true]

        Funcionario funcionario = Funcionario.get(Long.parseLong(params.id))
        funcionario.delete(flush: true)

        return retorno
    }

    Map get(Long id) {
        Map retorno = [success: true]

        Funcionario funcionario = Funcionario.get(id)

        retorno.registro = funcionario

        return retorno
    }

}
