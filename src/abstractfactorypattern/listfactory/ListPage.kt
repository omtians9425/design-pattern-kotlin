package abstractfactorypattern.listfactory

import abstractfactorypattern.factory.Page

class ListPage(title: String, author: String) : Page(title, author) {
    override fun makeHTML(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}