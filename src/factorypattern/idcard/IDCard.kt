package factorypattern.idcard

import factorypattern.framework.Product

class IDCard(val owner: String) : Product() {
    init {
        println("create $owner's card.")
    }
    override fun use() {
        println("use $owner's card.")
    }
}