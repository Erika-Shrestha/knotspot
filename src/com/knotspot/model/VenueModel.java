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
    private String contactNumber;
    private String venueType;
    private int capacity;
    private int rentFee;
    
    /**
     * a default constructor with no parameters 
     */
    public VenueModel(){}
    
    /**
     * an initialized constructor with parameters indicates the global variables with this keyword
     * @param venueId
     * @param venueName
     * @param address
     * @param city
     * @param contactNumber
     * @param venueType
     * @param capacity
     * @param rentFee 
     */
    public VenueModel(int venueId, String venueName, String address, String city, String contactNumber, String venueType, int capacity, int rentFee) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.address = address;
        this.city = city;
        this.contactNumber = contactNumber;
        this.venueType = venueType;
        this.capacity = capacity;
        this.rentFee = rentFee;
    }
    
    /**
     * gets the venue id 
     * @return venue id set by setter method
     */
    public int getVenueId() {
        return venueId;
    }
    
    /**
     * sets venue id with a parameter initialized to global variable venue id
     * @param venueId 
     */
    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }
    
    /**
     * gets venue name
     * @return venue name set by setter method
     */
    public String getVenueName() {
        return venueName;
    }
    
    /**
     * sets venue name with a parameter initialized to global variable venue name
     * @param venueName 
     */
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
    
    /**
     * gets venue address
     * @return address set by the setter method
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * sets venue address with a parameter initialized to global variable venue address
     * @param address 
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * gets method for venue city 
     * @return city set by the setter method
     */
    public String getCity() {
        return city;
    }
    
    /**
     * sets venue city with a parameter initialized to global variable venue city
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * gets venue contact number 
     * @return contact number set by the setter method 
     */
    public String getContactNumber() {
        return contactNumber;
    }
    
    /**
     * sets venue contact by passing parameter initialized to global variable venue contact
     * @param contactNumber 
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    /**
     * gets venue type 
     * @return venue type set by the setter method
     */
    public String getVenueType() {
        return venueType;
    }
    
    /**
     * sets venue type by passing parameter initialized to global variable venue type
     * @param venueType
     */
    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }
    
    /**
     * gets venue capacity 
     * @return capacity of venue set by the setter method
     */
    public int getCapacity() {
        return capacity;
    }
    
    /**
     * sets venue capacity by passing parameter initialized to global variable venue capacity
     * @param capacity 
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    /**
     * gets venue rent fee 
     * @return rent set by the setter method
     */
    public int getRentFee() {
        return rentFee;
    }
    
    /**
     * sets venue rent fee by passing parameter initialized to global variable venue rent fee
     * @param rentFee 
     */
    public void setRentFee(int rentFee) {
        this.rentFee = rentFee;
    }

    
    
}
