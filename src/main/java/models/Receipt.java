package models;

import java.util.Date;

public class Receipt {
    private String receiptId;
    private Date receiptDate;
    private Supplier supplier;
    private Book book;
    private int quantity;
    private double totalPrice;

    public Receipt(String receiptId, Date receiptDate, Supplier supplier, Book book, int quantity, double totalPrice) {
        this.receiptId = receiptId;
        this.receiptDate = receiptDate;
        this.supplier = supplier;
        this.book = book;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getter và setter cho các thuộc tính
    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
