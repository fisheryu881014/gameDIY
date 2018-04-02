package gamediy

import grails.converters.JSON

class PayActionController {

    def payActionService
    def qqPayActionService
    def index() {
        def result = payActionService.isActive()
        render result as JSON
    }

    def pay(String body, String fee, String type, String key, String license, String callbackUrl) {
        type = type ?: "default"
        switch (type.toUpperCase()) {
            case "QQ":
                // http://localhost:8080/payAction/pay?body=%E6%B5%8B%E8%AF%95&fee=1.00&type=qq&key=1a2b3c&license=9a2bea00cd59cb18fc0d0ca3ebcfe451
                redirect url: qqPayActionService.payAction(body, fee, key, license, callbackUrl)
                break
            default:
                redirect url: "http://www.baidu.com"
                break

        }
//        payActionService.payAction()
    }

    def sync(String orderNo, String synType, String status, String price, String time, String cpparam, String sign) {
        if (payActionService.syncSignCheck(orderNo, synType, status, price, time, cpparam, sign)) {
            payActionService.doSync(orderNo, synType, status, price, time, cpparam)
            render "success"
        } else {
            render "failed"
        }
    }




}
