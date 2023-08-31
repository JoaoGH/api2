package api2

import api2.command.CidadeCommand
import grails.gorm.transactions.Transactional
import grails.web.api.ServletAttributes

@Transactional
class CidadeService implements ServletAttributes {

    Map save(CidadeCommand command) {
        Map retorno = [success: true]

        Cidade cidade = new Cidade()
        cidade.nome = command.nome
        cidade.save(flush: true)

        retorno.cidade = cidade

        return retorno
    }
}
