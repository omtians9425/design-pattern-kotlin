package abstractfactorypattern

fun main(args: Array<String>) {

    //TODO specify class name
    val factory: Factory = Factory.getFactory("") ?: return

    //define links
    val asahi = factory.createLink("Asahi Shimbun", "http://www.asahi.com/")
    val yomiuri = factory.createLink("Yomiuri Shimbun", "http://www.yomiuri.co.jp/")
    val usYahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/")
    val jpYahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/")
    val excite = factory.createLink("Excite", "http://www.excite.com")
    val google = factory.createLink("Google", "http://www.google.com/")

    //define trays
    val trayNews = factory.createTray("News").apply {
        add(asahi)
        add(yomiuri)
    }
    val trayYahoo = factory.createTray("Yahoo!").apply {
        add(usYahoo)
        add(jpYahoo)
    }
    val traySearch = factory.createTray("Search Engine").apply {
        add(trayYahoo)
        add(excite)
        add(google)
    }

    //define page
    factory.createPage("LinkePage", "Hoge").apply {
        add(trayNews)
        add(traySearch)
        output()
    }
}