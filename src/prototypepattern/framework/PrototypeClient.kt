package prototypepattern.framework

/**
 * Client object for Prototype pattern.
 * This creates new instance with Prototype
 */
class PrototypeClient {
    private val showcase = hashMapOf<String, Product>()

    fun register(name: String, prototype: Product) {
        showcase[name] = prototype
    }
    fun create(protoName: String, customDecoration: Char? = null): Product  {
        val p: Product = showcase[protoName] ?: throw IllegalArgumentException("Invalid product name")
        return p.createClone(custom = customDecoration)
    }
}