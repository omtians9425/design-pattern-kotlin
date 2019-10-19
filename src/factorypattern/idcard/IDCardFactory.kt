package factorypattern.idcard

import factorypattern.framework.Factory
import factorypattern.framework.Product

class IDCardFactory : Factory() {
    private val _owners = mutableListOf<String>()

    override fun createProduct(owner: String): Product {
        return IDCard(owner)
    }

    override fun registerProduct(product: Product) {
        if(product is IDCard) {
            _owners.add(product.owner)
            println("register ${product.owner}.")
        }
    }

    override fun getOwners(): List<String> {
        return _owners.toList()
    }
}