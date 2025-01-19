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
 * The BinarySearch class provides methods to perform search on a list of VenueModel objects
 * based on id and name attribute.
 */
public class BinarySearch {

    /**
     * A back up temporary list used to store the venue details for searching
     */
    private static List<VenueModel> venueSearchArrays = new ArrayList<>();

    /**
     * Performs a search using binary search algorithm based on specific
     * attribute and search value.
     *
     * @param venueDetails the list of VenueModel objects to search through by
     * copying items in back up array
     * @param searchValue the value to search for.
     * @param searchBy the attribute to search by (e.g., "Id" or "Name").
     * @return a list called venueMatched where objects that match the search
     * criteria are stored.
     */
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

            if (midValue.equalsIgnoreCase(searchValue)) {
                venueMatched.add(venueSearchArrays.get(midIndex));
                int leftIndex = midIndex - 1;
                while (leftIndex >= 0) {
                    VenueModel leftVenue = venueSearchArrays.get(leftIndex);
                    String leftValue = getSearchOrder(leftVenue, searchBy);

                    if (leftValue.equalsIgnoreCase(searchValue)) {
                        venueMatched.add(venueSearchArrays.get(leftIndex));
                        leftIndex--;
                    } else {
                        break;
                    }
                }

                int rightIndex = midIndex + 1;
                while (rightIndex < venueSearchArrays.size()) {
                    VenueModel rightVenue = venueSearchArrays.get(rightIndex);
                    String rightValue = getSearchOrder(rightVenue, searchBy);

                    if (rightValue.equalsIgnoreCase(searchValue)) {
                        venueMatched.add(venueSearchArrays.get(rightIndex));
                        rightIndex++;
                    } else {
                        break;
                    }
                }
            }
            if (midValue.compareToIgnoreCase(searchValue) > 0) {
                highIndex = midIndex - 1;
            } else {
                lowIndex = midIndex + 1;
            }
        }

        return venueMatched;

    }

    /**
     * Retrieves the value of a specific attribute from a VenueModel object
     * based on the search key
     *
     * @param venue the VenueModel object to extract the value from
     * @param searchBy the search key (Id or Name)
     * @return the value of the specified attribute as a String
     */
    public static String getSearchOrder(VenueModel venue, String searchBy) {
        return (searchBy.equals("Id")) ? String.valueOf(venue.getVenueId())
                : (searchBy.equals("Name")) ? venue.getVenueName()
                : null;

    }

    /**
     * Performs a binary search on the list of VenueModel objects by their name
     *
     * @param venueDetails the list of VenueModel objects to search through
     * @param searchValue the name of venue to search for
     * @return a list of VenueModel objects with matching names
     */
    public static List<VenueModel> searchByName(List<VenueModel> venueDetails, String searchValue) {
        return performBinarySearch(venueDetails, searchValue, "Name");
    }

    /**
     * Performs a binary search on the list of VenueModel objects by their Id
     *
     * @param venueDetails the list of VenueModel objects to search through
     * @param searchValue the id of venue to search for
     * @return a list of VenueModel objects with matching ids
     */
    public static List<VenueModel> searchById(List<VenueModel> venueDetails, String searchValue) {
        return performBinarySearch(venueDetails, searchValue, "Id");
    }

}
