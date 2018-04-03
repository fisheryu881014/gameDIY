package gamediy

import grails.transaction.Transactional

@Transactional
class JdPayActionService {

    def getApiUrl() {
        "/1/jspay/wx/wx_api.do" // todo
    }
    def getType() {
        "JD"
    }
}
