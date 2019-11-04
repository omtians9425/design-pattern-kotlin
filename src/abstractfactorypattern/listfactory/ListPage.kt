package abstractfactorypattern.listfactory

import abstractfactorypattern.factory.Page

class ListPage(title: String, author: String) : Page(title, author) {
    override fun makeHTML(): String {
        return buildString {
            append("<html><head><title>$title</title></head>\n")
            append("<body>\n")
            append("<h1>$title</h1>\n")
            append("<ul>\n")
            for(item in content) {
                append(item.makeHTML())
            }
            append("</ul>\n")
            append("<hr><address>$author</address>")
            append("<body></html>\n")
        }
    }
}