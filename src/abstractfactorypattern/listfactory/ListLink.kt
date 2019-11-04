package abstractfactorypattern.listfactory

import abstractfactorypattern.factory.Link

class ListLink(caption: String, url: String) : Link(caption, url) {
    override fun makeHTML() = "    <li><a href=\"$url\">$caption</a></li>\n"
}
