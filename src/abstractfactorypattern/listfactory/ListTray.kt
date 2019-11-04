package abstractfactorypattern.listfactory

import abstractfactorypattern.factory.Tray

class ListTray(caption: String) : Tray(caption) {
    override fun makeHTML(): String {
        return buildString {
            append("<li>\n")
            append("$caption\n")
            append("<ul>\n")
            for(item in tray) {
                append(item.makeHTML())
            }
            append("</ul>\n")
            append("</li>\n")
        }
    }
}
