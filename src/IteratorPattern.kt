fun main() {
    val shelf = BookShelf()
    listOf(
        Book("Around the World in 80 days"),
        Book("Bible"),
        Book("Cinderella"),
        Book("Daddy-Long-Legs")
    ).forEach { shelf.appendBook(it) }

    //client only needs to know iterator
    val iterator = shelf.iterator()
    while (iterator.hasNext()) {
        val book = iterator.next() as? Book
        if(book != null) {
            println(book.name)
        }
    }
}

interface Aggregate {
    fun iterator(): Iterator
}

interface Iterator {
    fun hasNext(): Boolean
    fun next(): Any
}

//element object
class Book(val name: String)

//target aggregate object. this instantiates iterator object
class BookShelf : Aggregate {
    private val books = mutableListOf<Book>()

    fun getBookAt(index: Int): Book {
        return books[index]
    }

    fun appendBook(book: Book) {
        books.add(book)
    }

    fun getLength(): Int {
        return books.size
    }
    //instantiates concrete iterator
    override fun iterator(): Iterator {
        return BookShelfIterator(this)
    }
}

//encapsulates concrete implementation for iteration inside.
//in this case, the detail implementation is further encapsulated in the BookShelf object. (getBookAt and getLength)
class BookShelfIterator(private val bookShelf: BookShelf) : Iterator {
    private var index = 0

    override fun hasNext(): Boolean {
        return index < bookShelf.getLength()
    }

    override fun next(): Any {
        val book = bookShelf.getBookAt(index)
        index++
        return book
    }
}