/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knotspot.util;

import com.knotspot.model.VenueModel;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author LMU ID: 23048598 COLLEGE ID: 230024 ErikaShrestha
 */
public class ValidationUtil {

    //follow naming convention for regex pattern
    private static final Pattern ID_PATTERN = Pattern.compile("^[1-9][0-9]{4}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z][A-Za-z\\s'-]{0,49}$");
    private static final Pattern ADDRESS_PATTERN = Pattern.compile("^[a-zA-Z ]+$");
    private static final Pattern CONTACT_PATTERN = Pattern.compile("^98\\d{8}$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+$");
    private static final Pattern ALPHANUMERIC_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");  
    private static final Pattern ALPHABETIC_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    
    /**
     * checks if the passing parameter is null and throws a null pointer exception
     * @param value
     * @param attribute 
     */
    public static void isNullorEmpty(String value, String attribute) {
        if( value == null || value.trim().isEmpty())
            throw new NullPointerException(attribute + " is empty!");
            
    }
    
    /**
     * checks if the passing id parameter is valid from the pattern and throws a index out of bounds exception
     * calls null and empty method
     * calls number validation
     * @param venueId
     * @param attribute 
     */
    public static void isIdValid(String venueId, String attribute) {
        isNullorEmpty(venueId, attribute);
        isNumber(venueId, attribute);
        if (!ID_PATTERN.matcher(String.valueOf(venueId)).matches()){
            throw new IndexOutOfBoundsException(attribute +" must be of 5 digit and not begin with 0");
        }
    }

    public static void isNameValid(String venueName, String attribute) {
        isNullorEmpty(venueName, attribute);
        isAlphabetic(venueName, attribute);
        if (!NAME_PATTERN.matcher(String.valueOf(venueName)).matches()){
            throw new IllegalArgumentException(attribute +" must be in alphabets");
        }
        
    }

    public static void isAddressValid(String venueAddress, String attribute) {
        isNullorEmpty(venueAddress, attribute);
        isAlphabetic(venueAddress, attribute);
        if (!ADDRESS_PATTERN.matcher(venueAddress).matches()){
            throw new IllegalArgumentException(attribute +" must be a proper address");
        }
    }

    public static void isContactValid(String venueContact, String attribute) {
        isNullorEmpty(venueContact, attribute);
        if(!CONTACT_PATTERN.matcher(String.valueOf(venueContact)).matches()){
            throw new NumberFormatException(attribute +" must be of 10 digits");
        }
    }

    public static void isNumber(String value, String attribute) {
        if(!NUMBER_PATTERN.matcher(String.valueOf(value)).matches()){
        throw new NumberFormatException(attribute+ "in digit");}
        
    }

    public static void isAlphaNumeric(String value, String attribute) {
        if(!ALPHANUMERIC_PATTERN.matcher(String.valueOf(value)).matches()){
            throw new NumberFormatException("input value in number");
        }
    }
    
    public static void isAlphabetic(String value, String attribute) {
        if(!ALPHABETIC_PATTERN.matcher(value).matches()){
             throw new NumberFormatException("use only alpha characters");
        }
    }
    
    public static boolean isDuplicate(List<VenueModel> value, int venueId, String venueContact){
        for (VenueModel venues : value){
            if(venues.getVenueId()==venueId || venues.getContactNumber().equals(venueContact)){
                return true;
            }
        
        }
        return false;
    
    }
    
    public static void venueValidateColor(JTextField field, JLabel label, Color borderColor, Color textColor, String message, String title){
        field.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(borderColor, 2), title, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,javax.swing.border.TitledBorder.DEFAULT_POSITION,new java.awt.Font("Segoe UI", Font.PLAIN, 12),textColor));
        label.setText(message);
        label.setForeground(borderColor);
        
    
    }
    
    public static void authenticationColor(JLabel label, Color backgroundColor, Color textColor , boolean value, String message){
    label.setBackground(backgroundColor);
    label.setForeground(textColor);
    label.setText(message);
    label.setOpaque(value);
    }
    


}
