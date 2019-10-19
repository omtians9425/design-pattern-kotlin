package prototypepattern

import prototypepattern.framework.Product

/**
 * Concrete Prototype
 */
data class UnderlinePen(private val ulChar: Char) : Product {

    override fun use(s: String) {
        println("\" $s \"")
        print(" ")
        horizontalBorder(s)
    }

    override fun createClone(): Product {
        return copy()
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