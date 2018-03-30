package gamediy

import grails.transaction.Transactional

@Transactional
class QqPayActionService {

    String api_url = "/1/jspay/qq/qq_api.do"
    String app_id = "a0666fa64f77fdcd63c03e08f28535a1"

    def payActionService
    def payAction(String body, String fee, String userKey, String userLicense) {
        // 用户验证
        Client client = Client.findByKey(userKey)
        if (!client || userLicense != client.license) {
            return "/failed/invalid/client"
        }

        // 支付渠道可用性验证
        PayType payType = PayType.findByKey("QQ");
        if (!PayType || !payType.working) {
//            throw new Exception("Pay Type has turn off, please try others")
            return "/failed/turn/off"
        }

        String out_trade_no = payActionService.generateTradeNo("QQ")

        // 支付记录生成
        PayRecord record = new PayRecord(body:body, fee: fee, payType: payType, tradeNo: out_trade_no, client: client)
//        record.save()
        record.save(flush: true)

        payActionService.payAction(api_url, app_id, body, fee, out_trade_no)
    }
}
