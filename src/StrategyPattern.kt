/**
 * implementation of strategy pattern with lambda.
 * lambda replaces all interface. we only do implement strategy as method
 */
fun main() {
    val sato = Customer(name = "sato", fidelityScore = 500)
    val nakamura = Customer(name = "nakamura", fidelityScore = 2000)

    val cart = listOf(
        OrderItem("apple", 20, 1000.0),
        OrderItem("banana", 10, 2000.0),
        OrderItem("grape", 5, 500.0)
    )

    val largeCart = mutableListOf<OrderItem>().apply {
        (1..15).map { add(OrderItem(it.toString(), 10, 10.0)) }
    }

    //pass strategy for client object as method (reference for top level func)
    val satoOrder = Order(sato, cart, promo = ::fidelityPromo)
    val nakamuraOrder = Order(nakamura, cart, promo = ::fidelityPromo)
    account(satoOrder)
    account(nakamuraOrder)

    val satoBulkOrder = Order(sato, cart, promo = ::bulkPromo)
    val satoLargeOrder = Order(sato, largeCart, promo = ::largePromo)
    account(satoBulkOrder)
    account(satoLargeOrder)
}

fun account(order: Order) {
    println("############################################")
    println("<<<<order info>>>>")
    println("customer name: ${order.customer.name}")
    println("calculated by (strategy): ${order.promo}")
    println("ordered item:")
    for(item in order.cart) {
        println(item.productName)
    }
    println("total price: ${order.total()}")
    println("final price: ${order.finalPrice()}")
    println()
}

fun findBestPromo(order: Order, promos: List<(Order) -> Double>): Sequence<Pair<String, Double>>? {
    return promos.asSequence().map { Pair(it.toString(), it.invoke(order)) }.sortedBy { it.second }
}

data class Customer(val name: String, val fidelityScore: Int)

data class OrderItem(val productName: String, val qtyInKg: Int, val pricePerKg: Double) {
    fun total(): Double {
        return qtyInKg * pricePerKg
    }
}

//promo is strategy
class Order(val customer: Customer, val cart: List<OrderItem>, val promo: ((Order) -> Double)? = null) {
    fun total(): Double = cart.asSequence().sumByDouble { it.total() }

    fun finalPrice(): Double {
        val discount = promo?.invoke(this) ?: 0f.toDouble() //functionN interface has invoke method (SAM)
        return total() - discount
    }
}

//-----3 strategies-----
fun fidelityPromo(order: Order): Double {
    return if (order.customer.fidelityScore > 1000) {
        order.total() * 0.5
    } else {
        0f.toDouble()
    }
}

fun bulkPromo(order: Order): Double {
    var discount: Double = 0f.toDouble()

    for (item in order.cart) {
        if (item.qtyInKg >= 20) {
            discount += item.total() * 0.1
        }
    }
    return discount
}

fun largePromo(order: Order): Double {
    val uniqueItems = order.cart.toSet().size
    return if (uniqueItems >= 10) {
        order.total() * 0.07
    } else {
        0f.toDouble()
    }
}

