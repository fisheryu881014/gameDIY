package gamediy

import grails.converters.JSON

class PayActionController {

    def payActionService
    def qqPayActionService
    def index() {
        def result = payActionService.isActive()
        render result as JSON
    }

    def pay(String body, String fee, String type) {
        type = type ?: "defualt"
        switch (type.toUpperCase()) {
            case "QQ":
                redirect url: qqPayActionService.payAction(body, fee)
                break
            default:
                redirect url: "http://www.baidu.com"
                break

        }
//        payActionService.payAction()
    }




}
