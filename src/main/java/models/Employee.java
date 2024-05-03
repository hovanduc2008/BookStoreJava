package models;

public class Employee {
    private String name;
    private String position;
    private String employeeId;
    private String phoneNumber;
    private String email;

    public Employee(String name, String position, String employeeId, String phoneNumber, String email) {
        this.name = name;
        this.position = position;
        this.employeeId = employeeId;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getter và setter cho các thuộc tính
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
}
