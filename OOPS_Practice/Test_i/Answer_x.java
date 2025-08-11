import java.util.ArrayList;
import java.util.List;

public class Answer_x {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian("Swata Swayam Dash", library);

        librarian.addBook(new Book(false, "C++ Quant", "Hardcode coder"));
        librarian.addBook(new Book(false, "LLD in quant", "Therock"));

        Member m1 = new Member("billu");
        library.registerMember(m1);

        m1.borrowBook(library.getBooks().get(0));
        m1.borrowBook(library.getBooks().get(0));
    }
}

abstract class Person {
    protected String name;
    public Person(String name) {
        this.name = name;
    }
}

interface Borrowable {
    void borrowBook(Book book);
}

class Book {
    private boolean isBorrowed;
    private String title;
    private String author;

    Book(Boolean isBorrowed, String title, String author) {
        this.isBorrowed = isBorrowed;
        this.title = title;
        this.author = author;
    }
    public void setBorrowed() {
        this.isBorrowed = true;
    }

    public boolean isBorrowed() {
        return this.isBorrowed;
    }

    @Override
    public String toString() {
        return "Book: "+title+" by: "+author+ (isBorrowed ? " Not Available": " Available");
    }
}

class Member extends Person implements Borrowable {
    private List<Book> borrowedBooks = new ArrayList<>();

    public Member(String name) {
        super(name);
    }

    @Override
    public void borrowBook(Book book) {
        if(!book.isBorrowed()) {
            borrowedBooks.add(book);
            book.setBorrowed();
            System.out.println(name +" borrowed: "+ book);
        } else {
            System.out.println(book +" is already borrowed");
        }
    }
}

 
class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }
    public List<Member> getMembers() {
        return members;
    }

    public void registerMember(Member member) {
        members.add(member);
        System.out.println(member.name+ " registered");
    }
}


class Librarian extends Person {
    private Library library;
    public Librarian(String name,Library library) {
        super(name);
        this.library = library;
    }

    public void addBook(Book book) {
        library.getBooks().add(book);
        System.out.println(book +" added to library");
    }
}