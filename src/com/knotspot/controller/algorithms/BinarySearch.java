/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knotspot.controller.algorithms;

import com.knotspot.model.VenueModel;
import java.util.List;

/**
 *
 * @author Erika Shrestha
 * LMU ID: 23048598
 * COLLEGE ID: 230024
 */
public class BinarySearch {
    
    public static VenueModel binarySearch(List<VenueModel> venueDetails, String searchValue){
        int lowIndex= 0;
        int highIndex = venueDetails.size()-1;
        
        while(lowIndex<=highIndex){
            int midIndex = (lowIndex+highIndex)/2;
            String midValue = venueDetails.get(midIndex).getVenueName();
            
            if(midValue.toLowerCase().equals(searchValue.toLowerCase())){
                return venueDetails.get(midIndex);
            }
            
            if(midValue.compareToIgnoreCase(searchValue)<0){
                highIndex = midIndex-1;
            }
            else{
                lowIndex = midIndex +1;
            }
        }
        return null;
        
    }
    
    
}
