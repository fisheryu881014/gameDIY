import gamediy.Client
import gamediy.PayType

class BootStrap {

    def init = { servletContext ->
        if (!Client.findAll()) {
            Client client = new Client(name: "Test Client", description: "Just for test", key: "1a2b3c", action: true)
            client.license = String.format("%s_%s", client.name, client.key).encodeAsMD5().toString()
            client.save()
        }

        if (!PayType.findAll()) {
            PayType payType = new PayType(name: "QQ", key: "QQ", working: true).save()
        }
    }
    def destroy = {
    }
}
