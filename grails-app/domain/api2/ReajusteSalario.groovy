package api2

import java.time.LocalDate

class ReajusteSalario {

    LocalDate dataReajuste
    BigDecimal valorSalario

    static belongsTo = [funcionario: Funcionario]

    static mapping = {
        id generator: "increment"
        version false
    }

    static constraints = {
        dataReajuste nullable: false
        valorSalario nullable: false, precision: 6, scale: 2
        funcionario nullable: false
    }
}
