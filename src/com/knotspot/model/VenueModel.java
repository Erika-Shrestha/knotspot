/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knotspot.model;

/**
 *
 * @author 
 * LMU ID:23048598
 * COLLEGE ID: 230024
 * ErikaShrestha
 */
public class VenueModel {
    
    private int venueId;
    private String venueName;
    private String address;
    private String city;
    private int contactNumber;
    private String venueType;
    private int capacity;
    private int rentFee;
    
    public VenueModel(){}

    public VenueModel(int venueId, String venueName, String address, String city, int contactNumber, String venueType, int capacity, int rentFee) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.address = address;
        this.city = city;
        this.contactNumber = contactNumber;
        this.venueType = venueType;
        this.capacity = capacity;
        this.rentFee = rentFee;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getVenueType() {
        return venueType;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRentFee() {
        return rentFee;
    }

    public void setRentFee(int rentFee) {
        this.rentFee = rentFee;
    }

    
    
}
