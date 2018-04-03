package gamediy

import grails.transaction.Transactional

@Transactional
class WxPayActionService {

    def getApiUrl() {
        "/1/jspay/wxh5/wx_api.do"
    }
    def getType() {
        "WX"
    }
}
