package factorypattern.framework

abstract class Factory {
    /*
    Factory pattern is the template method pattern for instance creation.
    Wraps and encapsulates the instantiation. This template specifies returning new instance
     */
    fun create(owner: String) : Product {
        val p = createProduct(owner)
        registerProduct(p)
        return p
    }

    abstract fun registerProduct(product: Product)
    abstract fun createProduct(owner: String): Product

    abstract fun getOwners(): List<String>
}