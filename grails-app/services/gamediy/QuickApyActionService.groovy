package gamediy

import grails.transaction.Transactional

@Transactional
class QuickApyActionService {

    def getApiUrl() {
        "/1/jspay/wx/wx_api.do"
    }
    def getType() {
        "QUICK"
    }
}
