package prototypepattern.framework

/**
 * This is prototype
 */
interface  Product {
    fun use(s: String)
    fun createClone(): Product
}