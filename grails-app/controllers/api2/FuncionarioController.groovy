package api2

import api2.traits.ExceptionHandlers

class FuncionarioController implements ExceptionHandlers {

    static responseFormats = ['json']
    static defaultAction = "get"
    static allowedMethods = [

    ]

    FuncionarioService funcionarioService

    def save() {}

    def list() {}

    def update() {}

    def delete() {}

    def get() {}

}
