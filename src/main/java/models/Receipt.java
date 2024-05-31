package models;

import java.util.Date;
import java.io.Serializable;

public class Receipt implements Serializable {

   
    private String receiptId;
    private String receiptDate;
    private String supplier;
    private String book;
    private String quantity;
    private String totalPrice;
    private String employee;

    public Receipt(String receiptId, String receiptDate, String supplier, String book, String quantity,  String employee, String totalPrice) {
        this.receiptId = receiptId;
        this.receiptDate = receiptDate;
        this.supplier = supplier;
        this.book = book;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.employee = employee;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    

   
}
