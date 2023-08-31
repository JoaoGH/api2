package api2

import api2.command.CidadeCommand
import grails.rest.*
import grails.converters.*

class CidadeController {

    static responseFormats = ["json"]
	static defaultAction = "get"
    static allowedMethods = [
            save: "POST",
            list: "GET",
            update: "PUT",
            delete: "DELETE",
            get: "GET"
    ]

    CidadeService cidadeService

    def save(CidadeCommand command) {
        Map retorno = cidadeService.save(command)
        respond(retorno)
    }

    def list() {
        Map retorno = cidadeService.list()
        respond(retorno)
    }

    def update() {}

    def delete() {}

    def get() {}
}
