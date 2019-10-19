package factorypattern.framework

abstract class Factory {
    //Wraps and encapsulates the instantiation. This only specifies returning new instance
    fun create(owner: String) : Product {
        val p = createProduct(owner)
        registerProduct(p)
        return p
    }

    abstract fun registerProduct(product: Product)
    abstract fun createProduct(owner: String): Product
}