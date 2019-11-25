package bridgepattern

/**
 * The top hierarchy of the feature.
 * It's methods delegate to [DisplayImpl] that is bridge between feature and implementation.
 */
open class Display(private val impl: DisplayImpl) {

    fun open() {
        impl.rawOpen()
    }

    fun print() {
        impl.rawPrint()
    }

    fun close() {
        impl.rawClose()
    }

    fun display() {
        open()
        print()
        close()
    }
}