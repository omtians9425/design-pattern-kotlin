fun main () {
    val printBanner = PrintBannerAdapter(string = "Hello")
    printBanner.printStrong()
    printBanner.printWeak()
}

//target object which client uses
interface Print {
    fun printWeak()
    fun printStrong()
}

//Adaptee class
open class Banner(private val string: String) {
    protected fun showWithParen() {
        println("( $string )")
    }
    protected fun showWithAster() {
        println("* $string *")
    }
}

/*
Adapter object that is the leading role.
Inheritance version. This inherits Adaptee and call its method as target interface's method
 */
class PrintBannerAdapter(private val string: String) : Banner(string), Print {
    override fun printWeak() {
        showWithParen()
    }
    override fun printStrong() {
        showWithAster()
    }
}
