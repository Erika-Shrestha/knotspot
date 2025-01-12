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
 * @author Erika Shrestha LMU ID: 23048598 COLLEGE ID: 230024
 */
public class BinarySearch {

    private static List<VenueModel> venueSearchArrays = new ArrayList<>();

    public static List<VenueModel> performBinarySearch(List<VenueModel> venueDetails, String searchValue, String searchBy) {
        venueSearchArrays.clear();
        venueSearchArrays.addAll(venueDetails);
        List<VenueModel> venueMatched = new ArrayList<>();

        int lowIndex = 0;
        int highIndex = venueSearchArrays.size() - 1;

        while (lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            VenueModel midVenue = venueSearchArrays.get(midIndex);
            String midValue = getSearchOrder(midVenue, searchBy);

            if (midValue.toLowerCase().equals(searchValue.toLowerCase())) {
                venueMatched.add(venueSearchArrays.get(midIndex));   
            }
            if (midValue.compareToIgnoreCase(searchValue) > 0) {
                highIndex = midIndex - 1;
            } else {
                lowIndex = midIndex + 1;
            }
        }

        return venueMatched;

    }

    public static String getSearchOrder(VenueModel venue, String searchBy) {
        if (searchBy.equals("Id")) {
            return String.valueOf(venue.getVenueId());
        } else if (searchBy.equals("Name")) {
            return venue.getVenueName();
        } else {
            return String.valueOf(venue.getVenueType());
        }
    }

    public static List<VenueModel> searchByName(List<VenueModel> venueDetails, String searchValue) {
        return performBinarySearch(venueDetails, searchValue, "Name");
    }

    public static List<VenueModel> searchById(List<VenueModel> venueDetails, String searchValue) {
        return performBinarySearch(venueDetails, searchValue, "Id");
    }

    public static List<VenueModel> searchByType(List<VenueModel> venueDetails, String searchValue) {
        return performBinarySearch(venueDetails, searchValue, "Type");
    }
}
