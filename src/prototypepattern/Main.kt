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
    val p1 = client.create(upenKey)
    p1.use("Hello World.")
    val p2 = client.create(mboxKey)
    p2.use("Hello World.")
    val p3 = client.create(sboxKey)
    p3.use("Hello World")

}