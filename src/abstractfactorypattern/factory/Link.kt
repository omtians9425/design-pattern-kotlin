package abstractfactorypattern.factory

/**
 * Abstract parts class.
 */
abstract class Link(
    caption: String,
    protected val url: String
) : Item(caption) {

}