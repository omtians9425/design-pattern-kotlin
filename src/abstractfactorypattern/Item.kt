package abstractfactorypattern

/**
 * Base parts class. This class is the part of multiple abstract parts class.
 */
abstract class Item(protected val caption: String) {
    abstract fun makeHTML(): String
}