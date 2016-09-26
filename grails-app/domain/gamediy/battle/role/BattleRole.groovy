package gamediy.battle.role

import gamediy.role.BaseRole

class BattleRole {

    static constraints = {
    }
    static mapWith = "none"

    String userName
    int type // 0, player, 1, boss
    int level
    int physical
    int power
    int intelligence
    int endurance

    int hp
    int attack
    int defense

    String profession

    BattleRole(BaseRole role) {
        userName = role.userName
        type = role.type

        level = role.level
        physical = role.physical
        power = role.power
        intelligence = role.intelligence
        endurance = role.endurance

        hp = physical * 10
        defense = endurance * 1
        attack = role.profession.cacuAttack(role)

        profession = role.profession.name
    }
}
