package gamediy.role

import gamediy.profession.BaseProfession

class BaseRole {
    String userName
    int type

    // 基础属性值
    int level = 1         // 角色等级
    int physical = 9       // 体质, 决定生命值
    int power = 9         // 力量, 决定物理攻击力
    int intelligence = 9 // 智力, 决定智力攻击力
    int endurance = 9     // 耐力, 决定防御力


//    static transients = ['hp', 'attack', 'defense']
//    // 战斗属性值
//    int hp;
//    int attack;
//    int defense;

    static belongsTo = [profession: BaseProfession] // 门派或职业
//    static hasMany = [equipments : Equipment]       // 装备

    static constraints = {
        userName unique: true, blank: false
        type range: 0..2
    }

    def initBaseInfo() {
        physical += level       // 体质, 决定生命值
        power += level         // 力量, 决定物理攻击力
        intelligence += level // 智力, 决定智力攻击力
        endurance += level     // 耐力, 决定防御力
    }


//    private init(initLevel, initBaseValue, initProfession) {
//        level = initLevel
//        baseValue = initBaseValue
//        gamediy.profession.profession = initProfession
//    }



//    private cacuBaseInfo() {
////        int levelGrow = level - 1;
////        physical += levelGrow
////        power += levelGrow
////        intelligence += levelGrow
////        endurance += levelGrow
//        physical = power = intelligence = endurance = baseValue + level -1
//        if (!gamediy.profession.profession) {
//            gamediy.profession.profession = BaseProfession.findByName("No Profession");
//        }
//    }

//    def cacuBattleInfo() {
//        hp = physical * 10
//        defense = endurance * 1
//        attack = profession.cacuAttack(this)
//    }
}
