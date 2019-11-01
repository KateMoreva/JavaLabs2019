package c;

import java.util.Objects;

public class Book {

    private int id;
    private String author;
    private String name;
    private int year;

    Book(String author, String name, int year) {

        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if ((year < 0)&&(year > 2020)) {
            throw new IllegalArgumentException("There is something wrong with the year");
        }
        id=0;
        this.author = author;
        this.name = name;
        this.year = year;
    }

    int getId() {
        return id;
    }

    String getAuthor() {
        return author;
    }

    String getName() {
        return name;
    }

    int getYear() {
        return year;
    }

    void changeId(int id) {
        this.id = id;
    }

    void changeAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        this.author = author;
    }


    void changeName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }


    void changeYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return year == book.year &&
                author.equals(book.author) &&
                name.equals(book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,author, name, year);
    }

    @Override
    public String toString() {
        return "Book: " + id + '\'' +
                " author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year;
    }
}