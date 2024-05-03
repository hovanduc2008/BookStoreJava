package models;

public class OrderDetail {
    private Order order;
    private Book book;
    private int quantity;
    private double subtotal;

    public OrderDetail(Order order, Book book, int quantity, double subtotal) {
        this.order = order;
        this.book = book;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    // Getter và setter cho các thuộc tính
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
