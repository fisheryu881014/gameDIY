package gamediy

import javax.persistence.Entity

@Entity
class TypeRecord {
    // 支付方式启用或暂停记录
    static constraints = {
    }

//    Integer id
    PayType payType
    String action

    Date dateCreated
    Date lastUpdated
}
