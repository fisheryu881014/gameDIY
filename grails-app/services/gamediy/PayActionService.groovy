package gamediy

import grails.transaction.Transactional
import groovy.json.JsonSlurper
import groovyx.net.http.HttpBuilder

@Transactional
class PayActionService {

    def http = HttpBuilder.configure {
        request.uri = 'http://jspay.wiipay.cn/'
    }

    def isActive() {
        [resultType: "success"]
    }

    def payAction(String api_url, String app_id, String body, String total_fee, String out_trade_no) {
        userValidation() // 验证请求身份
        callRecordSave() // 保存用户请求记录
        callApiToPay(api_url, app_id, body, total_fee, out_trade_no)   // 调用支付接口
    }

    private void userValidation() {

    }

    private void callRecordSave() {

    }

    String api_key = "im8jvs8unejblx277a5cyendm6usx6iz"
    String callback_url = "http://www.baidu.com"
    String channel_id = "default"
    String format = "json"
    String version = "2.0"

    private void callApiToPay(String api_url, String app_id, String body, String total_fee, String out_trade_no) {
        String sign_prep = String.format("app_id=%s&body=%s&callback_url=%s&channel_id=%s&format=%s&out_trade_no=%s&total_fee=%s&version=%s%s",
                app_id, body, callback_url, channel_id, format, out_trade_no, total_fee, version, api_key)
        String sign = sign_prep.encodeAsMD5().toString().toUpperCase()

        String result = http.post {
            request.uri.path = api_url
            request.contentType = 'application/x-www-form-urlencoded'
            request.body = [app_id: app_id, body: body, callback_url: callback_url,
                            channel_id: channel_id, format: format, out_trade_no: out_trade_no,
                            total_fee: total_fee, version: version, sign: sign]
        }

        result
//        def resultObj = new JsonSlurper().parseText(result)
    }

    def generateTradeNo(String type) {
        String.format("%s_%s", type, String.valueOf(System.currentTimeMillis()))
    }
}
