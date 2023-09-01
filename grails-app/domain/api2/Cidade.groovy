package api2

class Cidade {

    Long id
    String nome

    static mapping = {
        id generator: "increment"
        version false
    }

    static constraints = {
        nome nullable: false, maxSize: 50
    }
}
