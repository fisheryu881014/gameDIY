package gamediy.profession

import gamediy.role.BaseRole

class BaseProfession {

    static constraints = {
    }
//    static hasMany = [roles: BaseRole]

    String name
    static hasMany = [role: BaseRole]

    def cacuAttack(BaseRole baseRole) {
        baseRole.power * 1.5;
    }
}
