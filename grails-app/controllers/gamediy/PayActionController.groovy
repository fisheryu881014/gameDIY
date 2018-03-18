package gamediy

import grails.converters.JSON

class PayActionController {

    def payActionService
    def index() {
        def result =  payActionService.payAction()
        render result as JSON
    }


}
