package gamediy

import gamediy.profession.BaseProfession
import gamediy.role.BaseRole
import grails.transaction.Transactional

// 做最基础的创建更新等操作，不做验证
@Transactional
class BaseRoleService {

    // 创建新用户
    def createNewBasePlayer(newName) {
        def newPlayer = new BaseRole(userName: newName, type: 0, profession: BaseProfession.findByName("No Profession"))
        newPlayer.initBaseInfo()
        newPlayer.save()
    }

    // 创建NPC
    def createBaseNPC(newName, newLevel, newPhy, newPower, newInte, newEndu, newProf) {
        def newPlayer = new BaseRole(userName: newName, level: newLevel, physical: newPhy, power: newPower,
                intelligence: newInte, endurance: newEndu, profession: newProf, type: 1)
        newPlayer.save()
    }

    def getBaseRoleByName(roleName) {
        BaseRole.findByUserName(roleName)
    }

    def getBaseRoleById(roleId) {
        BaseRole.findById(roleId)
    }
}
