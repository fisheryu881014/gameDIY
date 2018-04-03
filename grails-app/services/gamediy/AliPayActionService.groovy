package gamediy

import grails.transaction.Transactional

@Transactional
class AliPayActionService {

    def getApiUrl() {
        "/1/jspay/wx/wx_api.do" // todo
    }
    def getType() {
        "ALI"
    }
}
