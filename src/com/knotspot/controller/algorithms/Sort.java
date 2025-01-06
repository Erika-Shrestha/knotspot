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
public class Sort {

    private static List<VenueModel> venueSortArrays = new ArrayList<>();

    public static void performSelectionSort(List<VenueModel> venueDetails, boolean isAscend, String sortBy) {

        venueSortArrays.clear();
        venueSortArrays.addAll(venueDetails);

        for (int currentIndex = 0; currentIndex < venueSortArrays.size() - 1; currentIndex++) {
            VenueModel minVenue = venueSortArrays.get(currentIndex);
            String minVenueCapacity = getSortValue(minVenue, sortBy);
            int minIndex = currentIndex;

            for (int nextIndex = minIndex + 1; nextIndex < venueSortArrays.size(); nextIndex++) {

                if (isAscend) {
                    if (checkLesserThanForSelection(nextIndex, minVenueCapacity, sortBy)) {
                        minIndex = nextIndex;
                    }
                } else {
                    if (checkGreaterThanForSelection(nextIndex, minVenueCapacity, sortBy)) {
                        minIndex = nextIndex;
                    }
                }
            }
            VenueModel additionalIndex = venueSortArrays.get(currentIndex);
            venueSortArrays.set(currentIndex, venueSortArrays.get(minIndex));
            venueSortArrays.set(minIndex, additionalIndex);

        }
        venueDetails.clear();
        venueDetails.addAll(venueSortArrays);

    }

    public static void performInsertionSort(List<VenueModel> venueDetails, boolean isAscend, String sortBy) {
        venueSortArrays.clear();
        venueSortArrays.addAll(venueDetails);

        for (int i = 1; i < venueSortArrays.size(); i++) {
            VenueModel currentVenue = venueSortArrays.get(i);
            String current = getSortValue(currentVenue, sortBy);
            int previous = i - 1;

            if (isAscend) {

                while (checkLesserThanForInsertion(previous, current, sortBy)) {
                    venueSortArrays.set(previous + 1, venueSortArrays.get(previous));
                    previous--;
                }
                
            } else {
                while (checkGreaterThanForInsertion(previous, current, sortBy)) {
                    venueSortArrays.set(previous + 1, venueSortArrays.get(previous));
                    previous--;
                }
            }

            venueSortArrays.set(previous + 1, currentVenue);
        }

        venueDetails.clear();
        venueDetails.addAll(venueSortArrays);
    }

    // helper methods
    
    public static boolean isLesserThanId(int previous, String current) {
        return previous >= 0 && venueSortArrays.get(previous).getVenueId() > Integer.parseInt(current);
    }
    
    public static boolean isLesserThanCity(int previous, String current) {
        return previous >= 0 && venueSortArrays.get(previous).getCity().compareTo(current) > 0;
    }
    
    public static boolean isLesserThanName(int previous, String current) {
        return previous >= 0 && venueSortArrays.get(previous).getVenueName().compareTo(current) > 0;
    }
    
    public static boolean isLesserThanCapacity(int nextIndex, String minVenueCapacity ) {
        return venueSortArrays.get(nextIndex).getCapacity() > Integer.parseInt(minVenueCapacity);
    }
    
    public static boolean isLesserThanPrice(int fCounter,int sCounter, List<VenueModel> firstHalfVenue, List<VenueModel> secondHalfVenue) {
        return firstHalfVenue.get(fCounter).getRentFee() <= secondHalfVenue.get(sCounter).getRentFee();
    }
    
    public static boolean isGreaterThanId(int previous, String current) {
        return previous >= 0 && venueSortArrays.get(previous).getVenueId() < Integer.parseInt(current);
    }
    
    public static boolean isGreaterThanCity(int previous, String current) {
        return previous >= 0 && venueSortArrays.get(previous).getCity().compareTo(current) < 0;
    }
    
    public static boolean isGreaterThanName(int previous, String current) {
        return previous >= 0 && venueSortArrays.get(previous).getVenueName().compareTo(current) < 0;
    }
    
    public static boolean isGreaterThanCapacity(int nextIndex, String minVenueCapacity ) {
        return venueSortArrays.get(nextIndex).getCapacity() < Integer.parseInt(minVenueCapacity);
    }
    
    public static boolean isGreaterThanPrice(int fCounter,int sCounter, List<VenueModel> firstHalfVenue, List<VenueModel> secondHalfVenue) {
        return firstHalfVenue.get(fCounter).getRentFee() >= secondHalfVenue.get(sCounter).getRentFee();
    }
    
    
    public static boolean checkLesserThanForInsertion(int previous, String current, String sortBy) {
        if(sortBy.equals("Id")) {
            return isLesserThanId(previous,current);
        } else if (sortBy.equals("City")) {
            return isLesserThanCity(previous,current);
        } else{
            return isLesserThanName(previous, current);
        }
    }
    
    public static boolean checkGreaterThanForInsertion(int previous, String current, String sortBy) {
        if(sortBy.equals("Id")) {
            return isGreaterThanId(previous,current);
        } else if (sortBy.equals("City")) {
            return isGreaterThanCity(previous,current);
        } else {
            return isGreaterThanName(previous, current);
        }
    }
   
    public static boolean checkLesserThanForSelection(int nextIndex, String minVenueCapacity, String sortBy) {
        if(sortBy.equals("Capacity")){
            return isLesserThanCapacity(nextIndex, minVenueCapacity );
        }  
        return false;
    }
    
    public static boolean checkGreaterThanForSelection(int nextIndex, String minVenueCapacity, String sortBy) {
        if(sortBy.equals("Capacity")){
            return isGreaterThanCapacity(nextIndex, minVenueCapacity );
        }  
        return false;
    }
    
    public static boolean checkLesserThanForMerge(int fCounter,int sCounter, List<VenueModel> firstHalfVenue, List<VenueModel> secondHalfVenue, String sortBy) {
        if(sortBy.equals("Price")){
            return isLesserThanPrice(fCounter, sCounter, firstHalfVenue, secondHalfVenue) ;
        }  
        return false;
    }
    
    public static boolean checkGreaterThanForMerge(int fCounter,int sCounter, List<VenueModel> firstHalfVenue, List<VenueModel> secondHalfVenue, String sortBy) {
        if(sortBy.equals("Price")){
            return isGreaterThanPrice(fCounter, sCounter, firstHalfVenue, secondHalfVenue) ;
        }  
        return false;
    }

    //merge sort
    public static void performMergeSort(List<VenueModel> venueDetails, boolean isAscend, String sortBy) {
        venueSortArrays.clear();
        venueSortArrays.addAll(venueDetails);
        int size = venueSortArrays.size();

        if (size < 2) {
            return;
        }

        int midIndex = size / 2;
        List<VenueModel> firstHalfVenue = new ArrayList<>(midIndex);
        List<VenueModel> secondHalfVenue = new ArrayList<>(size - midIndex);

        for (int i = 0; i < midIndex; i++) {
            firstHalfVenue.add(i, venueSortArrays.get(i));
        }

        //we want to start the second arraylist as index 0 and not the value of midindex
        for (int i = midIndex; i < size; i++) {
            secondHalfVenue.add(i - midIndex, venueSortArrays.get(i));
        }

        //recursively call the same method to again break the elements into individual 
        performMergeSort(firstHalfVenue, isAscend, sortBy);
        performMergeSort(secondHalfVenue, isAscend, sortBy);

        //merge them now
        merge(venueSortArrays, firstHalfVenue, secondHalfVenue, isAscend, sortBy);

        venueDetails.clear();
        venueDetails.addAll(venueSortArrays);
    }

    private static void merge(List<VenueModel> venueArrays, List<VenueModel> firstHalfVenue, List<VenueModel> secondHalfVenue, boolean isAscend, String sortBy) {
        venueArrays.clear();

        int firstHalfLength = firstHalfVenue.size();
        int secondHalfLength = secondHalfVenue.size();

        int fCounter = 0, sCounter = 0, aCounter = 0;
        while (fCounter < firstHalfLength && sCounter < secondHalfLength) {
            if (isAscend) {
                if (checkLesserThanForMerge(fCounter, sCounter, firstHalfVenue, secondHalfVenue, sortBy)) {
                    venueArrays.add(aCounter, firstHalfVenue.get(fCounter));
                    fCounter++;
                } else {
                    venueArrays.add(aCounter, secondHalfVenue.get(sCounter));
                    sCounter++;
                }

            } else {
                if (checkGreaterThanForMerge(fCounter, sCounter, firstHalfVenue, secondHalfVenue, sortBy)) {
                    venueArrays.add(aCounter, firstHalfVenue.get(fCounter));
                    fCounter++;
                } else {
                    venueArrays.add(aCounter, secondHalfVenue.get(sCounter));
                    sCounter++;
                }

            }

            aCounter++;
        }
        while (fCounter < firstHalfLength) {
            venueArrays.add(aCounter, firstHalfVenue.get(fCounter));
            fCounter++;
            aCounter++;
        }

        while (sCounter < secondHalfLength) {
            venueArrays.add(aCounter, secondHalfVenue.get(sCounter));
            sCounter++;
            aCounter++;
        }

    }
    public static String getSortValue(VenueModel venue, String sortBy){
        if(sortBy.equals("Id")) {
            return String.valueOf(venue.getVenueId());
        } else if (sortBy.equals("City")) {
            return venue.getCity();
        } else if(sortBy.equals("Name")){
            return venue.getVenueName();
        }else if(sortBy.equals("Capacity")){
            return String.valueOf(venue.getCapacity());
        }
        else{
            return String.valueOf(venue.getRentFee());
        }
         
    }
    
}
