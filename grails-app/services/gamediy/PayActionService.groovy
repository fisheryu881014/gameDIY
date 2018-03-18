package gamediy

import grails.transaction.Transactional

@Transactional
class PayActionService {
    def payAction() {
        [resultType: "success"]
    }
}
