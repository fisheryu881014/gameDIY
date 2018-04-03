package gamediy

import grails.transaction.Transactional

@Transactional
class QqPayActionService {
     def getType() {
        return "QQ"
     }

    def getApiUrl() {
        return "/1/jspay/qq/qq_api.do"
    }
}
