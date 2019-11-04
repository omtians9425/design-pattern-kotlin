package abstractfactorypattern

import abstractfactorypattern.factory.Link

class ListLink(caption: String, url: String) : Link(caption, url){
    override fun makeHTML(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
