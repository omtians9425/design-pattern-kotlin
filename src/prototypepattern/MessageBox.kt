package prototypepattern

import prototypepattern.framework.Product

/**
 * Concrete Prototype
 */
data class MessageBox(val decoChar: Char) : Product {
    override fun use(s: String) {
        horizontalBorder(s)
        //body
        println("$decoChar $s $decoChar")
        horizontalBorder(s)
    }

    override fun createClone(): Product {
        return copy()
    }

    //helper for drawing
    private fun horizontalBorder(s: String) {
        val length = s.length + 4
        for(i in 0 until length) {
            print(decoChar)
        }
        println()
    }
}