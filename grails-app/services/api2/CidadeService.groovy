package api2

import api2.commands.CidadeCommand
import grails.gorm.transactions.Transactional
import grails.web.api.ServletAttributes
import javassist.NotFoundException
import org.springframework.dao.DataIntegrityViolationException

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

    Map list() {
        Map retorno = [:]

        List<Cidade> cidadeList = Cidade.list()

        retorno.total = cidadeList.size()
        retorno.records = cidadeList

        return retorno
    }

    Map update(CidadeCommand command) {
        Map retorno = [success: true]

        Cidade cidade = Cidade.get(params.id as Long)
        cidade.nome = command.nome
        cidade.save(flush: true)

        return retorno
    }

    Map delete(Long id) {
        Map retorno = [success: true]

        Cidade cidade = Cidade.findById(id)

        if (cidade) {
            try {
                cidade.delete(flush: true)
            } catch (DataIntegrityViolationException e) {
                retorno.success = false
                retorno.message = "Registro associado para um funcionario."
                retorno.error = e.getMessage()
            }
        } else {
            throw new NotFoundException("Não encontrada cidade para ${id}")
        }


        return retorno
    }

    Cidade get() {
        Long id = Long.parseLong(params.id)
        return Cidade.get(id)
    }

}
