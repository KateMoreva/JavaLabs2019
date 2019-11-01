package c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class BookShelf {

    private Map<Integer, Book> books;
    private int lastId;

    BookShelf() {
        this.books = new HashMap<>();
        lastId = -1;
    }

    void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        lastId++;
        book.changeId(lastId);
        books.put(lastId, book);
    }

    List<Book> getAllBooks() {
        return List.copyOf(books.values());
    }

    List<Book> getAllWhere(Predicate<Book> predicate) {
        return books.values().stream().filter(predicate).collect(Collectors.toList());
    }

    void updateAuthor(Book book, String newAuthor) {
        if (!books.containsValue(book)) {
            System.out.println("No book with id: " + book);
            return;
        }
        Book storedBook = getAllWhere(book1 -> book1.equals(book)).get(0);
        storedBook.changeAuthor(newAuthor);
    }

    void updateName(Book book, String newName) {
        if (!books.containsValue(book)) {
            System.out.println("No book with id: " + book);
            return;
        }
        Book storedBook = getAllWhere(book1 -> book1.equals(book)).get(0);
        storedBook.changeName(newName);
    }

    void updateYear(Book book, int newYear) {
        if (!books.containsValue(book)) {
            System.out.println("No book with id: " + book);
            return;
        }
        Book storedBook = getAllWhere(book1 -> book1.equals(book)).get(0);
        storedBook.changeYear(newYear);
    }

    void deleteBook(Book book) {
        if (!books.containsValue(book)) {
            System.out.println("No book with id: " + book);
            return;
        }
        Book storedBook = getAllWhere(book1 -> book1.equals(book)).get(0);
        books.remove(storedBook.getId());
    }

   public boolean checkBook(Book book){
        if (!books.containsValue(book)) {
            System.out.println("No book with id: " + book);
            return false;
        }
       return true;
   }
   // private void checkForBookInShelf(Book book) {
//        if (!books.containsValue(book)) {
//            System.out.println("No book with id: " + book);
//            return;
//            //throw new NoSuchElementException("No book with id: " + book);
//        }
    //}
}
