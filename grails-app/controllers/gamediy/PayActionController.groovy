package gamediy

import grails.converters.JSON

class PayActionController {

    def payActionService
    def index() {
        def result = payActionService.isActive()
        render result as JSON
    }

    def pay() {
        payActionService.payAction()
    }




}
