package gamediy

class PayRecord {

    static constraints = {
    }

//    Integer id
    String body
    String fee
//    PayType type
    String tradeNo
//    Client client

    Date dateCreated
    Date lastUpdated

    static belongsTo = [payType: PayType, client: Client]
}
