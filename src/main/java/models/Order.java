package models;

import java.util.Date; // Import để sử dụng lớp Date
import java.util.ArrayList; // Thêm dòng này để import ArrayList
import java.util.List; // Thêm dòng này để import List

import java.io.Serializable;

public class Order implements Serializable {

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Order(int orderId, String orderDate, String customer, String phone, String email, String address, double totalAmount) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customer = customer;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.totalAmount = totalAmount;
    }
    private int orderId;
    private String orderDate;
    private String customer;
    private String phone;
    private String email;
    private String address;
    private double totalAmount;

    
}
