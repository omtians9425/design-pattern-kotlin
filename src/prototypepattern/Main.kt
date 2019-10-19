package prototypepattern

import prototypepattern.framework.PrototypeClient

fun main() {
    val upen = UnderlinePen('~')
    val upenKey = "strong message"

    val mbox = MessageBox('*')
    val mboxKey = "warning box"

    val sbox = MessageBox('/')
    val sboxKey = "slash box"

    val client = PrototypeClient().apply {
        register(upenKey, upen)
        register(mboxKey, mbox)
        register(sboxKey, sbox)
    }

    //creation and use
    val message = "Hello World."
    val p1 = client.create(upenKey)
    p1.use(message)
    val p2 = client.create(mboxKey)
    p2.use(message)
    val p3 = client.create(sboxKey)
    p3.use(message)

    val custom1 = client.create(sboxKey, customDecoration = '@')
    custom1.use(message)

    val custom2 = client.create(upenKey, customDecoration = '-')
    custom2.use(message)

}