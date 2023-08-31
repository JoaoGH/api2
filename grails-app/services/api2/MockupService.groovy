package api2

import grails.gorm.transactions.Transactional

import java.time.LocalDate

@Transactional
class MockupService {

    def popularDados() {
        Cidade cidade = new Cidade()
        cidade.setNome("Sapiranga")
        cidade.save(flush: true)

        Cidade cidade2 = new Cidade()
        cidade2.setNome("Parobé")
        cidade2.save(flush: true)

        Cidade cidade3 = new Cidade()
        cidade3.setNome("Taquara")
        cidade3.save(flush: true)

        Funcionario funcionario = new Funcionario()
        funcionario.setNome("João")
        funcionario.setCidade(cidade2)
        funcionario.save(flush: true)

        Funcionario funcionario2 = new Funcionario()
        funcionario2.setNome("Gabriel")
        funcionario2.setCidade(cidade)
        funcionario2.save(flush: true)

        ReajusteSalario reajusteSalario = new ReajusteSalario()
        reajusteSalario.setDataReajuste(LocalDate.now())
        reajusteSalario.setValorSalario(1320 as BigDecimal)
        reajusteSalario.setFuncionario(funcionario2)
        reajusteSalario.save(flush: true)
    }
}
