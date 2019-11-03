package abstractfactorypattern

import java.io.FileWriter
import java.io.IOException

/**
 * Abstract product class.
 */
abstract class Page(
    protected val title: String,
    protected val author: String
) {
    protected val content = mutableListOf<Item>()

    fun add(item: Item) {
        content.add(item)
    }

    fun output() {
        try {
            val filename = "$title.html"
            FileWriter(filename).apply {
                write(makeHTML())
                close()
            }
            println("$filename is created.")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    abstract fun makeHTML(): String
}