package abstractfactorypattern

import abstractfactorypattern.factory.Factory
import abstractfactorypattern.factory.Link
import abstractfactorypattern.factory.Page
import abstractfactorypattern.factory.Tray

class ListFactory : Factory() {
    override fun createLink(caption: String, url: String): Link  = ListLink(caption, url)
    override fun createTray(caption: String): Tray = ListTray(caption)
    override fun createPage(title: String, author: String): Page = ListPage(title, author)
}