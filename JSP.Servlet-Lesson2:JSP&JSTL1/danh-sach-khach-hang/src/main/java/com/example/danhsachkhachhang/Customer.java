package com.example.danhsachkhachhang;

public class Customer {
    private String name;
    private String birthdate;
    private String address;
    private String imagePath;

    public Customer(String name, String birthdate, String address, String imagePath) {
        this.name = name;
        this.birthdate = birthdate;
        this.address = address;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
