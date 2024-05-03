package models;

import java.util.ArrayList; // Thêm dòng này để import ArrayList
import java.util.List; // Thêm dòng này để import List

public class Customer {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private List<Order> orders;

    public Customer(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    // Getter và setter cho các thuộc tính
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    // Phương thức thêm đơn hàng
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Phương thức xóa đơn hàng
    public void removeOrder(Order order) {
        orders.remove(order);
    }
}
