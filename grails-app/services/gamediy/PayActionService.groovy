package gamediy

import grails.transaction.Transactional

@Transactional
class PayActionService {

    def payAction() {
        // TODO 验证请求身份


        [resultType: "success"]
    }

    private void callApiToPay() {
        String api_url = "http://jspay.wiipay.cn/1/jspay/ali/ali_api.do" // 接口url
        String api_key = "hdfuiahsuifhuidhuaihuihfuhduiasudbfudisa" // 秘钥(key)

        String app_id = "app_id" // 需提供
        String body = "body" // 应该是传入的
        String callback_url = "callback_url" // 回调地址
        String channel_id = "default"
        String format = "json"
        String out_trader_no = "trader_no"
        String total_fee = "0.01"
        String version = "2.0"

        String sign_prep = String.format("app_id=%s&body=%s&callback_url=%s&channel_id=%s&format=%s&out_trader_no=%s&total_fee=%s&version=%s%s",
                app_id, body, callback_url, channel_id, format, out_trader_no, total_fee, version, api_key)
        String sign = sign_prep.encodeAsMD5().toString().toUpperCase()


    }
}
