package com.sakethbalijepalli.Assignment.Models;

public class EmployeeDto {
    String name;
    String city;
    String mobileNumber;
    String dept;


    public EmployeeDto() {
    }

    public EmployeeDto(String name, String city, String mobileNumber, String dept) {
        this.name = name;
        this.city = city;
        this.mobileNumber = mobileNumber;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
