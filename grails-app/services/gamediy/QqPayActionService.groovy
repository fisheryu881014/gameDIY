package gamediy

import grails.transaction.Transactional

@Transactional
class QqPayActionService {

    String api_url = "/1/jspay/qq/qq_api.do"
    String app_id = "a0666fa64f77fdcd63c03e08f28535a1"

    def payActionService
    def payAction(String body, String fee) {
        String out_trade_no = payActionService.generateTradeNo("QQ")
        payActionService.payAction(api_url, app_id, body, fee, out_trade_no)
    }
}
