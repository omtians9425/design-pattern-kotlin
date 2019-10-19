package prototypepattern

import prototypepattern.framework.Product

/**
 * Concrete Prototype
 */
data class MessageBox(val decoChar: Char, private val additionalDeco: Char = ' ') : Product {
    override fun use(s: String) {
        horizontalBorder(s)
        //body
        println("$decoChar$additionalDeco$s$additionalDeco$decoChar")
        horizontalBorder(s)
    }

    override fun createClone(custom: Char?): Product {
        return copy(additionalDeco = custom ?: additionalDeco)
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