package factorypattern

import factorypattern.framework.Product
import factorypattern.idcard.IDCardFactory

fun main() {
    val factory = IDCardFactory()
    val card1: Product = factory.create("sato") //client doesn't care the concrete object(IDCard)
    val card2: Product = factory.create("saito")
    val card3: Product = factory.create("nishimura")
    card1.use()
    card2.use()
    card3.use()
    println(factory.getOwners().joinToString())
}