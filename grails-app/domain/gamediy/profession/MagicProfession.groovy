package gamediy.profession

import gamediy.role.BaseRole

class MagicProfession extends BaseProfession {

    static constraints = {
    }

    def cacuAttack(BaseRole baseRole) {
        baseRole.intelligence * 1.5;
    }
}
