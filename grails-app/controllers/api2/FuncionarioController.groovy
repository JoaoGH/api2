package api2

import api2.traits.ExceptionHandlers

class FuncionarioController implements ExceptionHandlers {

    static responseFormats = ['json']
    static defaultAction = "get"
    static allowedMethods = [
            save: "POST",
            list: "GET"
    ]

    FuncionarioService funcionarioService

    def save() {
        Map retorno = funcionarioService.save()
        respond(retorno)
    }

    def list() {
        Map retorno = funcionarioService.list()
        respond(retorno)
    }

}