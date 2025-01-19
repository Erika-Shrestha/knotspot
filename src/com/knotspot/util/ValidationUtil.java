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
 * @author LMU ID: 23048598 
 * COLLEGE ID: 230024 
 * ErikaShrestha
 * The ValidationUtil class contains regex patterns to limit the data input.
 * These pattern validate attributes such as venue ID, name, address, contact number
 * and ensure they meet specific formatting criteria. 
 * It also provides methods for handling duplicate checks and alphabetic or numbers.
 */
public class ValidationUtil {

    /*follow naming convention for regex pattern*/
    // Pattern to validate 5-digit IDs that do not begin with 0
    private static final Pattern ID_PATTERN = Pattern.compile("^[1-9][0-9]{4}$");
    // Pattern to validate venue names (must be alphabets, including spaces, hyphens, or apostrophes)
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z][A-Za-z\\s'-]{3,49}$");
    // Pattern to validate addresses (must be alphabets and spaces, with length between 4 and 30 characters)
    private static final Pattern ADDRESS_PATTERN = Pattern.compile("^[a-zA-Z ]{4,30}$");
    // Pattern to validate contact numbers (must start with 98 followed by 8 digits)
    private static final Pattern CONTACT_PATTERN = Pattern.compile("^98\\d{8}$");
    // Pattern to validate if the value consists of only digits
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+$");  
    // Pattern to validate alphabetic values (only alphabets and spaces)
    private static final Pattern ALPHABETIC_PATTERN = Pattern.compile("^[A-Za-z\\s]+$");
    
    /**
     * checks if the passing parameter is null and throws a null pointer exception
     * @param value the value to check
     * @param attribute the name of the attribute to use in the exception message
     * @throws NullPointerException if the value is null or empty
     */
    public static void isNullorEmpty(String value, String attribute) {
        if( value == null || value.trim().isEmpty())
            throw new NullPointerException(attribute + " is empty!");
            
    }
    
    /**
     * checks if the passing id parameter is valid from the pattern and throws a index out of bounds exception
     * calls null and empty method
     * calls number validation
     * @param venueId the venue ID to validate
     * @param attribute the name of the attribute to use in the exception message
     * @throws IndexOutOfBoundsException if the venue ID does not match the regex format for Id
     */
    public static void isIdValid(String venueId, String attribute) {
        isNullorEmpty(venueId, attribute);
        isNumber(venueId, attribute);
        if (!ID_PATTERN.matcher(String.valueOf(venueId)).matches()){
            throw new IndexOutOfBoundsException(attribute +" must be of 5 digit and not begin with 0");
        }
    }
    
    /**
     * checks if the passing name parameter is valid from the pattern and throws a IllegalArgumentException
     * calls null and empty method
     * calls alphabetic validation
     * @param venueName the venue name to validate
     * @param attribute the name of the attribute to use in the exception message
     * @throws IllegalArgumentException if the venue name does not match the required pattern or length
     */
    public static void isNameValid(String venueName, String attribute) {
        isNullorEmpty(venueName, attribute);
        isAlphabetic(venueName, attribute);
        if(venueName.length()<=4 || venueName.length()>=50){
            throw new IllegalArgumentException(attribute +" must be in between 4 and 50");
        }
        if (!NAME_PATTERN.matcher(String.valueOf(venueName)).matches()){
            throw new IllegalArgumentException(attribute +" must be in alphabets");
        }
        
    }
    
    /**
     * checks if the passing address parameter is valid from the pattern and throws a IllegalArgumentException
     * calls null and empty method
     * calls alphabetic validation
     * @param venueAddress the venue address to validate
     * @param attribute the name of the attribute to use in the exception message
     * @throws IllegalArgumentException if the venue address does not match the required pattern or length
     */
    public static void isAddressValid(String venueAddress, String attribute) {
        isNullorEmpty(venueAddress, attribute);
        isAlphabetic(venueAddress, attribute);
        if(venueAddress.length()<=5 || venueAddress.length()>=31){
            throw new IllegalArgumentException(attribute +" must be in between 4 and 31");
        }
        if (!ADDRESS_PATTERN.matcher(venueAddress).matches()){
            throw new IllegalArgumentException(attribute +" must be a proper address");
        }
    }
    
    /**
     * checks if the passing contact number parameter is valid from the pattern and throws a NumberFormatException
     * calls null and empty method
     * calls number validation
     * @param venueContact the venue contact number to validate
     * @param attribute the name of the attribute to use in the exception message
     * @throws NumberFormatException if the venue contact number does not match the regex format for contact number
     */
    public static void isContactValid(String venueContact, String attribute) {
        isNullorEmpty(venueContact, attribute);
        isNumber(venueContact, attribute);
        if(!CONTACT_PATTERN.matcher(String.valueOf(venueContact)).matches()){
            throw new NumberFormatException(attribute +" must be of 10 digits and start with 98");
        }
    }
    
    /**
     * Validates if the given value is numeric
     * @param value the value to validate
     * @param attribute the name of the attribute to use in the exception message
     * NumberFormatException if the value is not numeric
     */
    public static void isNumber(String value, String attribute) {
        if(!NUMBER_PATTERN.matcher(String.valueOf(value)).matches()){
        throw new NumberFormatException(attribute+ "in digit");}
        
    }
    
    /**
     * Checks if the given value is numeric for search
     * @param value the value to validate
     * @return true if the value is numeric, otherwise false
     */
    public static boolean isNumberForSearchValue(String value) {
        return NUMBER_PATTERN.matcher(String.valueOf(value)).matches();
        
    }

    /**
     * Validates if the given value is alphabetic
     * @param value the value to validate
     * @param attribute the name of the attribute to use in the exception message
     * NumberFormatException if the value is not alphabetic
     */
    public static void isAlphabetic(String value, String attribute) {
        if(!ALPHABETIC_PATTERN.matcher(value).matches()){
             throw new NumberFormatException("use only alpha characters");
        }
    }
    
    /**
     * Checks if the given value is alphabetic for search
     * @param value the value to validate
     * @return true if the value is alphabetic, otherwise false
     */
    public static boolean isAlphabeticForSearchValue(String value) {
        return ALPHABETIC_PATTERN.matcher(value).matches();
    }
    
    /**
     * Checks for duplicates in the list of venues based on venue ID or contact number
     * @param value the list of venues to check
     * @param venueId the venue ID to check for duplicates
     * @param venueContact the venue contact number to check for duplicates
     * @return true if a duplicate is found, otherwise false
     */
    public static boolean isDuplicate(List<VenueModel> value, int venueId, long venueContact){
        for (VenueModel venues : value){
            if(venues.getVenueId()==venueId || venues.getContactNumber()==venueContact){
                return true;
            }
        
        }
        return false;
    
    }
    
    /**
     * Sets the color and feedback message for a JTextField and JLabel used for 
     * validation feedback in manage venues page of the GUI front design
     * @param field the JTextField to update
     * @param label the JLabel to display the message
     * @param borderColor the color for the text field's border
     * @param textColor the color for the label's text
     * @param message the feedback message to display
     * @param title the title to display in the text field's border
     */
    public static void venueValidateColor(JTextField field, JLabel label, Color borderColor, Color textColor, String message, String title){
        field.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(borderColor, 2), title, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,javax.swing.border.TitledBorder.DEFAULT_POSITION,new java.awt.Font("Segoe UI", Font.BOLD, 12),textColor));
        label.setText(message);
        label.setForeground(borderColor);
        
    
    }
    
    /**
     * Sets the color and feedback message for authentication validation 
     * of login page in the GUI front design
     * @param label the JLabel to display the message
     * @param backgroundColor the background color for the label
     * @param textColor the text color for the label
     * @param value the opacity of the label (true or false)
     * @param message the feedback message to specific value
     */
    public static void authenticationColor(JLabel label, Color backgroundColor, Color textColor , boolean value, String message){
    label.setBackground(backgroundColor);
    label.setForeground(textColor);
    label.setText(message);
    label.setOpaque(value);
    }
    


}
