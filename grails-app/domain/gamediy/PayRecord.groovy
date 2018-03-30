package gamediy

import java.time.LocalDateTime

class PayRecord {

    static constraints = {
    }

    Integer id
    String body
    String fee
    String type
    String tradeNo
    Client client


}

class Client {
    Integer id
    String name
    String description
    String key
    String license
    Boolean action
}

class PayType {
    Integer id
    String name
    Boolean working
}

class TypeRecord {
    Integer id
    String action
    LocalDateTime time
}
