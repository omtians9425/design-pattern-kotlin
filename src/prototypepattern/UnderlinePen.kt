package prototypepattern

import prototypepattern.framework.Product

/**
 * Concrete Prototype
 */
data class UnderlinePen(private val ulChar: Char, private val additionalDeco: Char=' ') : Product {
    override fun use(s: String) {
        println("\"$additionalDeco$s$additionalDeco\"")
        print(" ")
        horizontalBorder(s)
    }

    override fun createClone(custom: Char?): Product {
        return copy(additionalDeco = custom ?: additionalDeco)
    }

    //helper
    private fun horizontalBorder(s: String) {
        val length = s.length + 2
        for(i in 0 until length) {
            print(ulChar)
        }
        println()
    }
}