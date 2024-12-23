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
    
    public static boolean isNullorEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isIdValid(String venueId) {
        return !isNullorEmpty(venueId) && ID_PATTERN.matcher(String.valueOf(venueId)).matches();
    }

    public static boolean isNameValid(String venueName) {
        return !isNullorEmpty(venueName) && NAME_PATTERN.matcher(String.valueOf(venueName)).matches();
    }

    public static boolean isAddressValid(String venueAddress) {
        return !isNullorEmpty(venueAddress) && ADDRESS_PATTERN.matcher(String.valueOf(venueAddress)).matches();
    }

    public static boolean isContactValid(String venueContact) {
        return !isNullorEmpty(venueContact) && CONTACT_PATTERN.matcher(String.valueOf(venueContact)).matches();
    }

    public static boolean isNumber(String value) {
        return !isNullorEmpty(value) && NUMBER_PATTERN.matcher(String.valueOf(value)).matches();
    }

    public static boolean isAlphaNumeric(String value) {
        return !isNullorEmpty(value) && ALPHANUMERIC_PATTERN.matcher(String.valueOf(value)).matches();
    }
    
    public static boolean isAlphabetic(String value) {
        return !isNullorEmpty(value) && ALPHABETIC_PATTERN.matcher(String.valueOf(value)).matches();
    }
    

}
