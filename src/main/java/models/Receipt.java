package models;

import java.util.Date;
import java.io.Serializable;

public class Receipt implements Serializable {

   
    private int receiptId;
    private String receiptDate;
    private String supplier;
    private String book;
    private int quantity;
    private int totalPrice;
    private String employee;

    public Receipt(int receiptId, String receiptDate, String supplier, String book, int quantity,  String employee, int totalPrice) {
        this.receiptId = receiptId;
        this.receiptDate = receiptDate;
        this.supplier = supplier;
        this.book = book;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.employee = employee;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    

   
}
