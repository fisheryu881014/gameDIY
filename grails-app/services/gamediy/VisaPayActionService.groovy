package gamediy

import grails.transaction.Transactional

@Transactional
class VisaPayActionService {

    def getApiUrl() {
        "/1/jspay/un/un_api.do" // todo
    }
    def getType() {
        "VISA"
    }
}
