fun main () {
    val printBanner = PrintBannerAdapter(string = "Hello")
    printBanner.printStrong()
    printBanner.printWeak()

    val printBanner2 = PrintBannerAdapterByDelegation(string = "World")
    printBanner2.printStrong()
    printBanner2.printWeak()

    val another = MoreStrongPrintBanner(printBanner)
    another.printStrong()
    another.printWeak()
}

//target object which client uses
interface Print {
    fun printWeak()
    fun printStrong()
}

//Adaptee class
open class Banner(private val string: String) {
    fun showWithParen() {
        println("( $string )")
    }
    fun showWithAster() {
        println("* $string *")
    }
}

/*
Adapter object that is the leading role.
Inheritance version. This inherits Adaptee and call its method as target interface's method
 */
class PrintBannerAdapter(val string: String) : Banner(string), Print {
    override fun printWeak() {
        showWithParen()
    }
    override fun printStrong() {
        showWithAster()
    }
}

abstract class Print2 {
    abstract fun printWeak()
    abstract fun printStrong()
}

/*
The following, delegation version
Get adaptee as an argument and delegate to it
 */
class PrintBannerAdapterByDelegation(private val string: String) : Print2() {
    private val banner: Banner = Banner(string)

    override fun printWeak() {
        banner.showWithParen()
    }

    override fun printStrong() {
        banner.showWithAster()
    }
}

class MoreStrongPrintBanner(private val anotherAdapter: PrintBannerAdapter) : Print by anotherAdapter {
    override fun printStrong() {
        println("********** ${anotherAdapter.string} **********")
    }
}