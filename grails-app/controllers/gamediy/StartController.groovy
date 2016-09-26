package gamediy

import grails.converters.JSON

class StartController {
    def baseRoleService
    def battleRoleService

    def index() {
        def fisher = battleRoleService.createPlayer("fisher")
        session.setAttribute("role", fisher)
        render fisher as JSON
    }

    def boss() {
        def boss = baseRoleService.getBaseRoleByName("boss${params.id}")
        def result = ["boss": boss, "user": session.getAttribute("role")]
        render result as JSON
    }
}
