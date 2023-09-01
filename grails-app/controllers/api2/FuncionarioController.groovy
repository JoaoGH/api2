package api2

import api2.traits.ExceptionHandlers

class FuncionarioController implements ExceptionHandlers {

    static responseFormats = ['json']
    static defaultAction = "get"
    static allowedMethods = [
            save: "POST",
            list: "GET",
            update: "PUT",
            delete: "DELETE"
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

    def update() {
        Map retorno = funcionarioService.update()
        respond(retorno)
    }

    def delete() {
        Map retorno = funcionarioService.delete()
        respond(retorno)
    }

}
