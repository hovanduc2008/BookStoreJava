package models;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private String description;
    private List<Book> books;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        this.books = new ArrayList<>();
    }

    // Getter và setter cho các thuộc tính
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // Phương thức thêm sách vào danh mục
    public void addBook(Book book) {
        books.add(book);
    }

    // Phương thức xóa sách khỏi danh mục
    public void removeBook(Book book) {
        books.remove(book);
    }
}
