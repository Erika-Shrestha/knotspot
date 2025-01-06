/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knotspot.controller.algorithms;

import com.knotspot.model.VenueModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erika Shrestha
 * LMU ID: 23048598
 * COLLEGE ID: 230024
 */
public class BinarySearch {
    
    private static List<VenueModel> venueSearchArrays = new ArrayList<>();
    
    public static List<VenueModel> binarySearch(List<VenueModel> venueDetails, String searchValue){
        venueSearchArrays.clear();
        venueSearchArrays.addAll(venueDetails);
        List<VenueModel> venueMatched= new ArrayList<>();
        
        int lowIndex= 0;
        int highIndex = venueSearchArrays.size()-1;
        
        while(lowIndex<=highIndex){
            int midIndex = (lowIndex+highIndex)/2;
            String midValue = venueSearchArrays.get(midIndex).getVenueType();
            
            if(midValue.toLowerCase().equals(searchValue.toLowerCase())){
                venueMatched.add(venueSearchArrays.get(midIndex));
            }
            
            if(midValue.compareToIgnoreCase(searchValue)<0){
                highIndex = midIndex-1;
            }
            else{
                lowIndex = midIndex +1;
            }
        }
        venueDetails.clear();
        venueDetails.addAll(venueMatched);
        
        return venueMatched;
        
    }
    
    
}
