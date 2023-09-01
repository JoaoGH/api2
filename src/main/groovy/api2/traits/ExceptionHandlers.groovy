package api2.traits

import grails.artefact.controller.RestResponder
import javassist.NotFoundException

trait ExceptionHandlers implements RestResponder {

    def handleNullPointerException(NullPointerException e) {
        respond([message: e.getMessage() ?: "NullPointerException"], status: 400)
    }

    def handleNotFoundException(NotFoundException e) {
        respond([message: e.getMessage()], status: 404)
    }

    def handleNumberFormatException(NumberFormatException e) {
        respond([message: "Formato invalido"], status: 400)
    }

    def handleException(Exception e) {
        respond([message: "Contate o admin"], status: 400)
    }
}