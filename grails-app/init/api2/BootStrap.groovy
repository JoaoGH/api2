package api2

class BootStrap {

    MockupService mockupService

    def init = { servletContext ->
        mockupService.popularDados()
    }
    def destroy = {
    }
}
