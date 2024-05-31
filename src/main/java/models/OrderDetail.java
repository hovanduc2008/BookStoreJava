package models;

import java.io.Serializable;

public class OrderDetail implements Serializable {

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
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

    public OrderDetail(int orderID, String book, int quantity, double subtotal) {
        this.orderID = orderID;
        this.book = book;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }
    private int orderID;
    private String book;
    private int quantity;
    private double subtotal;

    
}
