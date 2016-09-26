import gamediy.profession.BaseProfession
import gamediy.profession.MagicProfession
import gamediy.profession.PhysicsProfession
import gamediy.role.BaseRole

class BootStrap {

    def init = { servletContext ->
        BaseProfession baseProfession
        if (!BaseProfession.findAll()) {
            baseProfession = new BaseProfession(name: "No Profession").save()
            new PhysicsProfession(name: "Physics Profession").save()
            new MagicProfession(name: "Magic Profession").save()
        } else {
            baseProfession = BaseProfession.findByName("No Profession")
        }

        if (!BaseRole.findAllByUserName("superAdmin")) {
            def fisher = new BaseRole(userName: "superAdmin", level: 1000, physical: 9999, power: 9999,
                    intelligence: 9999, endurance: 9999, profession: baseProfession, type: 0)
            fisher.save()
        }

        if (!BaseRole.findAllByType(1)) {
            new BaseRole(userName: "boss1", level: 1, physical: 5, power: 5, intelligence: 5, endurance: 5, profession: baseProfession, type: 1).save()
            new BaseRole(userName: "boss2", level: 1, physical: 6, power: 6, intelligence: 6, endurance: 6, profession: baseProfession, type: 1).save()
            new BaseRole(userName: "boss3", level: 1, physical: 7, power: 7, intelligence: 7, endurance: 7, profession: baseProfession, type: 1).save()
            new BaseRole(userName: "boss4", level: 1, physical: 8, power: 8, intelligence: 8, endurance: 8, profession: baseProfession, type: 1).save()
            new BaseRole(userName: "boss5", level: 1, physical: 9, power: 9, intelligence: 9, endurance: 9, profession: baseProfession, type: 1).save()
        }
    }
    def destroy = {
    }
}
