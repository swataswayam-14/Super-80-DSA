import java.util.Objects;

public class Answer_ix {
    
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    //override equals
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true; // same reference
        if(obj == null || getClass() != obj.getClass()) return false;

        Book book = (Book) obj;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
    /*
    If two objects are equal according to equals(), they must have the same hashCode()

    if we override equals() without updating hashCode() : 
        - equal objects may end up in different hash buckets in collections like HashSet or as keys in HashMap
        - this causes unexpected behaviour


        Book b1 = new Book("java", "james");
        Book b2 = new Book("java", "james");
        HashSet<Book> = new HashSet<>();
        set.add(b1);

        print(set.contains(b2)) : Might print false if hashCode() is not consistent
     */

    @Override
    public String toString() {
        return "Book: "+title+" Author: "+author;
    }
// DTOs (Data Transfer Objects) store data and are often logged, debugged, or displayed.

// Default toString() (from Object) returns a cryptic string like Book@7d4991ad.

// Overriding provides human-readable representation, making debugging and logging easier:
}