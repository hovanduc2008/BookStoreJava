package models;

import java.util.Date; // Import để sử dụng lớp Date
import java.util.ArrayList; // Thêm dòng này để import ArrayList
import java.util.List; // Thêm dòng này để import List

public class Order {
    private String orderId;
    private Date orderDate;
    private Customer customer;
    private List<Book> books;
    private double totalAmount;
    private boolean isPaid;

    public Order(String orderId, Date orderDate, Customer customer, List<Book> books, double totalAmount, boolean isPaid) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customer = customer;
        this.books = books;
        this.totalAmount = totalAmount;
        this.isPaid = isPaid;
    }

    // Getter và setter cho các thuộc tính
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
