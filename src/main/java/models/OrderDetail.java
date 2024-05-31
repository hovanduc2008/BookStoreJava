package models;

public class OrderDetail {

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
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

    public OrderDetail(String orderID, String book, int quantity, double subtotal) {
        this.orderID = orderID;
        this.book = book;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }
    private String orderID;
    private String book;
    private int quantity;
    private double subtotal;

    
}
