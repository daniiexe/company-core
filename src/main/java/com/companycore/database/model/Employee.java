package com.companycore.database.model;

public class Employee {
    private int id;
    private String fistName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Employee(int id, String fistName, String lastName, String phoneNumber, String email) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getFistName() {return fistName;}
    public void setFistName(String fistName) {this.fistName = fistName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
