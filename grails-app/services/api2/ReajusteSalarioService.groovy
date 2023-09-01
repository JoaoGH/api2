package api2

import grails.gorm.transactions.Transactional
import grails.web.api.ServletAttributes
import javassist.NotFoundException

import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Transactional
class ReajusteSalarioService implements ServletAttributes {

    Map save() {
        Map retorno = [:]

        Funcionario funcionario = Funcionario.get(request.JSON.idFuncionario)

        if (!funcionario) {
            throw new NotFoundException("Funcionario nao encontrado")
        }

        ReajusteSalario reajusteSalario = new ReajusteSalario()
        reajusteSalario.setDataReajuste(getLocalDateByParameter(request.JSON.dataReajuste))
        reajusteSalario.setValorSalario(request.JSON.valorSalario as BigDecimal)
        reajusteSalario.setFuncionario(funcionario)
        reajusteSalario.save(flush: true)

        retorno.success = true
        retorno.registro = getShowRecord(reajusteSalario)

        return retorno
    }

    protected LocalDate getLocalDateByParameter(String parameter) {
        return LocalDate.parse(parameter, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    }

    protected Map getShowRecord(ReajusteSalario reajusteSalario) {
        return [
                id          : reajusteSalario.id,
                dataReajuste: reajusteSalario.dataReajuste.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                valorSalario: reajusteSalario.valorSalario,
                funcionario : [
                        id: reajusteSalario.funcionario.id,
                        nome: reajusteSalario.funcionario.nome
                ]
        ]
    }

    Map list() {
        Map retorno = [:]

        List<ReajusteSalario> reajusteSalarioList = ReajusteSalario.findAll()

        retorno.total = reajusteSalarioList.size()
        retorno.registros = []

        reajusteSalarioList.each {
            retorno.registros << getShowRecord(it)
        }

        return retorno
    }

}
