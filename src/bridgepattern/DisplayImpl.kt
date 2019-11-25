package bridgepattern

/**
 * The top hierarchy of the Implementation of [Display].
 */
abstract class DisplayImpl {
    abstract fun rawOpen()
    abstract fun rawPrint()
    abstract fun rawClose()
}