/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knotspot.controller;

import java.util.regex.Pattern;


/**
 *
 * @author LMU ID: 23048598 COLLEGE ID: 230024 ErikaShrestha
 */
public class ValidationUtil {

    //follow naming convention for regex pattern
    private static final Pattern ID_PATTERN = Pattern.compile("^[1-9][0-9]{4}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z][A-Za-z\\s'-]{0,49}$");
    private static final Pattern ADDRESS_PATTERN = Pattern.compile("^[A-Za-z0-9\\s,.-]{1,100}$");
    private static final Pattern CONTACT_PATTERN = Pattern.compile("^98\\d{8}$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+$");
    private static final Pattern ALPHANUMERIC_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");  
    private static final Pattern ALPHABETIC_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    
    public static void isNullorEmpty(String value, String attribute) {
        if( value == null || value.trim().isEmpty())
            throw new NullPointerException(attribute + " is empty!");
            
    }

    public static void isIdValid(String venueId, String attribute) {
        isNullorEmpty(venueId, attribute);
        isNumber(venueId, attribute);
        if (!ID_PATTERN.matcher(String.valueOf(venueId)).matches()){
            throw new IndexOutOfBoundsException(attribute +" is incorrect!");
        }
    }

    public static void isNameValid(String venueName, String attribute) {
        isNullorEmpty(venueName, attribute);
        isAlphabetic(venueName, attribute);
        if (!NAME_PATTERN.matcher(String.valueOf(venueName)).matches()){
            throw new IllegalArgumentException(attribute +" is incorrect!");
        }
        
    }

    public static void isAddressValid(String venueAddress, String attribute) {
        isNullorEmpty(venueAddress, attribute);
        isAlphabetic(venueAddress, attribute);
        if (!ADDRESS_PATTERN.matcher(venueAddress).matches()){
            throw new IllegalArgumentException(attribute +" is incorrect!");
        }
    }

    public static void isContactValid(String venueContact, String attribute) {
        isNullorEmpty(venueContact, attribute);
        if(!CONTACT_PATTERN.matcher(String.valueOf(venueContact)).matches()){
            throw new NumberFormatException(attribute +" is incorrect!");
        }
    }

    public static void isNumber(String value, String attribute) {
        if(!NUMBER_PATTERN.matcher(String.valueOf(value)).matches()){
        throw new NumberFormatException("input value in number");}
        
    }

    public static void isAlphaNumeric(String value, String attribute) {
        if(!ALPHANUMERIC_PATTERN.matcher(String.valueOf(value)).matches()){
            throw new NumberFormatException("input value in number");
        }
    }
    
    public static void isAlphabetic(String value, String attribute) {
        if(!ALPHABETIC_PATTERN.matcher(value).matches()){
             throw new NumberFormatException("input value in number");
        }
    }
    

}
