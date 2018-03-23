package gamediy

import grails.converters.JSON
import grails.transaction.Transactional
import groovy.json.JsonSlurper
import groovyx.net.http.HttpBuilder
import jdk.nashorn.internal.parser.JSONParser
import org.grails.web.json.JSONObject

import java.time.LocalDateTime

@Transactional
class PayActionService {

    def http = HttpBuilder.configure {
        request.uri = 'http://jspay.wiipay.cn/'
    }

    def payAction() {
        // TODO 验证请求身份

        callApiToPay();

        [resultType: "success"]
    }

    private void callApiToPay() {
        String api_url = "/1/jspay/ali/ali_api.do" // 接口url
        String api_key = "im8jvs8unejblx277a5cyendm6usx6iz" // 秘钥(key)

        String app_id = "d84511ccd85d7162479bc0144c58df39" // 需提供
        String body = "测试支付" // 应该是传入的
        String callback_url = "http://www.baidu.com" // 回调地址
        String channel_id = "default"
        String format = "json"
        String out_trade_no = String.valueOf(System.currentTimeMillis())
        String total_fee = "1.00"
        String version = "2.0"

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
        def resultObj = new JsonSlurper().parseText(result)


    }
}
