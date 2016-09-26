package gamediy

import gamediy.battle.role.BattleRole
import grails.transaction.Transactional

@Transactional
class BattleRoleService {

    def baseRoleService

    def createPlayer(userName) {
        def baseRole = baseRoleService.createNewBasePlayer(userName)
        new BattleRole(baseRole)
    }

    def getBattleRoleByName(userName) {
        def baseRole = baseRoleService.getBaseRoleByName(userName)
        new BattleRole(baseRole)
    }
}
