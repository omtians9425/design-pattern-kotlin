package abstractfactorypattern

import java.lang.Exception

/**
 * Abstract factory class.
 */
abstract class Factory {

    fun getFactory(classname: String): Factory? {
        return try {
            Class.forName(classname).kotlin.objectInstance as Factory
        } catch (e: ClassNotFoundException) {
            println("Class $classname is not found.")
            null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * Factory methods of Parts and Product.
     */
    abstract fun createLink(caption: String, url: String): Link
    abstract fun createTray(caption: String): Tray
    abstract fun createPage(title: String, author: String): Page
}