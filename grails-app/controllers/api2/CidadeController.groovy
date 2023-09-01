package api2

import api2.command.CidadeCommand
import grails.rest.*
import grails.converters.*
import javassist.NotFoundException

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

    def update(CidadeCommand command) {
        Map retorno = cidadeService.update(command)
        respond(retorno)
    }

    def delete(Long id) {
        Map retorno = cidadeService.delete(id)
        respond(retorno)
    }

    def get() {}

    def handleNullPointerException(NullPointerException e) {
        respond([message: e.getMessage() ?: "NullPointerException"], status: 400)
    }

    def handleNotFoundException(NotFoundException e) {
        respond([message: e.getMessage()], status: 404)
    }

}
