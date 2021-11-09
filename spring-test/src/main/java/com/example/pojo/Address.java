package com.example.pojo;

/**
 * @author dzx
 * @data 2021/10/20 -16:31
 */
public class Address {
    public Address(String address) {
        this.address = address;
    }

    public Address() {
    }

    String address;

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
