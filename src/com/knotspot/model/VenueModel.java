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
 * The VenueModel class represents a venue with its properties such as venue ID, name, address, city, contact number,
 * venue type, capacity, and rent fee. It provides constructors to initialize a venue and getter and setter methods 
 * to access and modify the venue's attributes.
 */
public class VenueModel {
    
    private int venueId;            //unique id of venue
    private String venueName;       //name of venue
    private String address;         // location of venue
    private String city;            // city where venue is located
    private long contactNumber;     // contact number for the venue
    private String venueType;       // Type of venue
    private int capacity;           // Capacity of the venue (number of people it can accommodate)
    private double rentFee;         // fee for renting venue
    
    /**
     * Default constructor that initializes a new VenueModel object with default values 
     */
    public VenueModel(){}
    
    /**
     * Parameterized constructor that initializes a new VenueModel 
     * object with the provided values that indicate global variables with this keyword.
     * 
     * @param venueId        unique ID of the venue
     * @param venueName      name of the venue
     * @param address        location of venue
     * @param city           city where the venue is located
     * @param contactNumber  contact number for the venue
     * @param venueType      type of the venue
     * @param capacity       capacity of the venue (maximum number of people)
     * @param rentFee        fee for renting venue
     */
    public VenueModel(int venueId, String venueName, String address, String city, long contactNumber, String venueType, int capacity, double rentFee) {
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
     * @param venueId the venue ID to set
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
     * @param venueName the venue name to set
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
     * @param address the venue address to set
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
     * @param city the venue city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * gets venue contact number 
     * @return contact number set by the setter method 
     */
    public long getContactNumber() {
        return contactNumber;
    }
    
    /**
     * sets venue contact by passing parameter initialized to global variable venue contact
     * @param contactNumber the contact number for venue to set
     */
    public void setContactNumber(long contactNumber) {
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
     * @param venueType the venue type to set
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
     * @param capacity the capacity of venue to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    /**
     * gets venue rent fee 
     * @return rent set by the setter method
     */
    public double getRentFee() {
        return rentFee;
    }
    
    /**
     * sets venue rent fee by passing parameter initialized to global variable venue rent fee
     * @param rentFee the venue rent fee to set
     */
    public void setRentFee(double rentFee) {
        this.rentFee = rentFee;
    }

    
    
}
