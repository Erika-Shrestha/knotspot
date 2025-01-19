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
 * The sort class provides different sorting algorithms (insertion, selection and merge) on a
 * list of VenueModel objects based on two sorting order (ascending or
 * descending)
 */
public class Sort {

    /**
     * A back up temporary list used to store the venue details for sorting
     */
    private static List<VenueModel> venueSortArrays = new ArrayList<>();

    /**
     * Performs Selection Sort on the given list of VenueModel objects based on
     * the specified attribute and order
     *
     * @param venueDetails the list of VenueModel objects to sort through by
     * copying items in back up array
     * @param isAscend true for ascending order, false for descending order
     * @param sortBy the attribute to sort by (Capacity)
     */
    public static void performSelectionSort(List<VenueModel> venueDetails, boolean isAscend, String sortBy) {

        venueSortArrays.clear();
        venueSortArrays.addAll(venueDetails);

        for (int currentIndex = 0; currentIndex < venueSortArrays.size() - 1; currentIndex++) {
            VenueModel minVenue = venueSortArrays.get(currentIndex);
            String minVenueValue = getSortValue(minVenue, sortBy);
            int minIndex = currentIndex;

            for (int nextIndex = minIndex + 1; nextIndex < venueSortArrays.size(); nextIndex++) {

                if (isAscend) {
                    if (checkLesserThanForSelection(nextIndex, minVenueValue, sortBy)) {
                        minIndex = nextIndex;
                    }
                } else {
                    if (checkGreaterThanForSelection(nextIndex, minVenueValue, sortBy)) {
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

    /**
     * Performs Insertion Sort on the given list of VenueModel objects based on
     * the specified attribute and order
     *
     * @param venueDetails the list of VenueModel objects to sort through by
     * copying items in back up array
     * @param isAscend true for ascending order, false for descending order
     * @param sortBy the attribute to sort by (Id, Name and City)
     */
    public static void performInsertionSort(List<VenueModel> venueDetails, boolean isAscend, String sortBy) {
        venueSortArrays.clear();
        venueSortArrays.addAll(venueDetails);

        for (int i = 1; i < venueSortArrays.size(); i++) {
            VenueModel currentVenue = venueSortArrays.get(i);
            String current = getSortValue(currentVenue, sortBy);
            int previous = i - 1;

            if (isAscend) {

                while (previous >= 0 && checkLesserThanForInsertion(previous, current, sortBy)) {
                    venueSortArrays.set(previous + 1, venueSortArrays.get(previous));
                    previous--;
                }

            } else {
                while (previous >= 0 && checkGreaterThanForInsertion(previous, current, sortBy)) {
                    venueSortArrays.set(previous + 1, venueSortArrays.get(previous));
                    previous--;
                }
            }

            venueSortArrays.set(previous + 1, currentVenue);
        }

        venueDetails.clear();
        venueDetails.addAll(venueSortArrays);

    }

    /**
     * Performs Merge Sort on the given list of VenueModel objects based on the specified attribute and order
     * @param venueDetails the list of VenueModel objects to sort through by
     * copying items in back up array
     * @param isAscend true for ascending order, false for descending order
     * @param sortBy the attribute to sort by (Price = rentFee)
     */
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
        mergeSortedSublist(venueSortArrays, firstHalfVenue, secondHalfVenue, isAscend, sortBy);

        venueDetails.clear();
        venueDetails.addAll(venueSortArrays);
    }

    /**
     * Merges two sorted sublists into a single sorted list
     * @param venueArrays the list to store the merged elements
     * @param firstHalfVenue the first sorted sublist
     * @param secondHalfVenue the second sorted sublist
     * @param isAscend true for ascending order, false for descending order
     * @param sortBy the attribute to sort by (Price = rentFee)
     */
    private static void mergeSortedSublist(List<VenueModel> venueArrays, List<VenueModel> firstHalfVenue, List<VenueModel> secondHalfVenue, boolean isAscend, String sortBy) {
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

    /**
     * Compares the venue ID at previous index with current value to check 
     * if the ID is greater than the current value
     * @param previous the index of the previous venue in the list
     * @param current the ID of the current venue as a string
     * @return true if the venue ID at the previous index is greater than the current value, 
     * and previous is equals or greater than 0, otherwise false
     */
    public static boolean isLesserThanId(int previous, String current) {
        return previous >= 0 && venueSortArrays.get(previous).getVenueId() > Integer.parseInt(current);
    }

    /**
     * Compares the venue City at previous index with current value to check 
     * if the City is greater than the current value
     * @param previous the index of the previous venue in the list
     * @param current the City of the current venue as a string
     * @return true if the venue City at the previous index is greater than the current value, 
     * and previous is equals or greater than 0, otherwise false
     */
    public static boolean isLesserThanCity(int previous, String current) {
        return previous >= 0 && venueSortArrays.get(previous).getCity().compareToIgnoreCase(current) > 0;
    }

    /**
     * Compares the venue Name at previous index with current value to check 
     * if the Name is greater than the current value
     * @param previous the index of the previous venue in the list
     * @param current the Name of the current venue as a string
     * @return true if the venue name at the previous index is greater than the current value, 
     * and previous is equals or greater than 0, otherwise false
     */
    public static boolean isLesserThanName(int previous, String current) {
        return previous >= 0 && venueSortArrays.get(previous).getVenueName().compareToIgnoreCase(current) > 0;
    }

    /**
     * Checks if the capacity at the next index is lesser than a given minimum capacity
     * @param nextIndex the index of the next venue in the list
     * @param minVenueValue the minimum capacity value as a string
     * @return true if the capacity at the next index is lesser than 
     * the specified value, otherwise false
     */
    public static boolean isLesserThanCapacity(int nextIndex, String minVenueValue) {
        return venueSortArrays.get(nextIndex).getCapacity() < Integer.parseInt(minVenueValue);
    }

    /**
     * Compares the rent fee of venues from two separate lists to check 
     * if the fee in the first list is lesser or equal to the fee in the second list
     * @param fCounter the index of the current venue in the first list
     * @param sCounter the index of the current venue in the second list
     * @param firstHalfVenue the first list of venue models
     * @param secondHalfVenue the second list of venue models
     * @return true if the rent fee of the venue in the first list is lesser 
     * or equal to the venue in the second list, otherwise false
     */
    public static boolean isLesserThanPrice(int fCounter, int sCounter, List<VenueModel> firstHalfVenue, List<VenueModel> secondHalfVenue) {
        return firstHalfVenue.get(fCounter).getRentFee() <= secondHalfVenue.get(sCounter).getRentFee();
    }

    /**
     * Compares the venue ID at previous index with current value to check 
     * if the ID is lesser than the current value
     * @param previous the index of the previous venue in the list
     * @param current the ID of the current venue as a string
     * @return true if the venue ID at the previous index is lesser than the current value, 
     * and previous is equals or greater than 0, otherwise false
     */
    public static boolean isGreaterThanId(int previous, String current) {
        return previous >= 0 && venueSortArrays.get(previous).getVenueId() < Integer.parseInt(current);
    }

    /**
     * Compares the venue City at previous index with current value to check 
     * if the City is lesser than the current value
     * @param previous the index of the previous venue in the list
     * @param current the City of the current venue as a string
     * @return true if the venue City at the previous index is lesser than the current value, 
     * and previous is equals or greater than 0, otherwise false
     */
    public static boolean isGreaterThanCity(int previous, String current) {
        return previous >= 0 && venueSortArrays.get(previous).getCity().compareToIgnoreCase(current) < 0;
    }

    /**
     * Compares the venue Name at previous index with current value to check 
     * if the Name is lesser than the current value
     * @param previous the index of the previous venue in the list
     * @param current the Name of the current venue as a string
     * @return true if the venue Name at the previous index is lesser than the current value 
     * and previous is equals or greater than 0, otherwise false
     */
    public static boolean isGreaterThanName(int previous, String current) {
        return previous >= 0 && venueSortArrays.get(previous).getVenueName().compareToIgnoreCase(current) < 0;
    }

    /**
     * Checks if the capacity at the next index is greater than a given minimum capacity
     * @param nextIndex the index of the next venue in the list
     * @param minVenueValue the minimum capacity value as a string
     * @return true if the capacity at the next index is greater than 
     * the specified value, otherwise false
     */
    public static boolean isGreaterThanCapacity(int nextIndex, String minVenueValue) {
        return venueSortArrays.get(nextIndex).getCapacity() > Integer.parseInt(minVenueValue);
    }

    /**
     * Compares the rent fee of venues from two separate lists to check 
     * if the fee in the first list is greater or equal to the fee in the second list
     * @param fCounter the index of the current venue in the first list
     * @param sCounter the index of the current venue in the second list
     * @param firstHalfVenue the first list of venue models
     * @param secondHalfVenue the second list of venue models
     * @return true if the rent fee of the venue in the first list is greater 
     * or equal to the venue in the second list, otherwise false
     */
    public static boolean isGreaterThanPrice(int fCounter, int sCounter, List<VenueModel> firstHalfVenue, List<VenueModel> secondHalfVenue) {
        return firstHalfVenue.get(fCounter).getRentFee() >= secondHalfVenue.get(sCounter).getRentFee();
    }

    /**
     * Checks if the current VenueModel object has a lesser value than the previous value for insertion sort
     * @param previous the index of the previous VenueModel
     * @param current the current value to compare
     * @param sortBy the attribute to compare by (Id, Name or City)
     * @return true if the current value is lesser than the value at previous index
     */
    public static boolean checkLesserThanForInsertion(int previous, String current, String sortBy) {
        return (sortBy.equals("Id")) ? isLesserThanId(previous, current)
                : (sortBy.equals("City")) ? isLesserThanCity(previous, current)
                : isLesserThanName(previous, current);

    }

    /**
     * Checks if the current VenueModel object has a greater value than the previous value for insertion sort
     * @param previous the index of the previous VenueModel
     * @param current the current value to compare
     * @param sortBy the attribute to compare by (Id, Name or City)
     * @return true if the current value is greater than the value at previous index
     */
    public static boolean checkGreaterThanForInsertion(int previous, String current, String sortBy) {
        return (sortBy.equals("Id")) ? isGreaterThanId(previous, current)
                : (sortBy.equals("City")) ? isGreaterThanCity(previous, current)
                : isGreaterThanName(previous, current);

    }

    /**
     * Checks if the value at the next index is lesser than the provided minimum value for a given sort key
     * @param nextIndex the index of the next element to compare
     * @param minVenueValue the minimum value to compare against (represented as a string)
     * @param sortBy the attribute to compare by (Capacity)
     * @return true if the value at the next index is lesser than the minimum value 
     * for the specified sort key, otherwise false
     */
    public static boolean checkLesserThanForSelection(int nextIndex, String minVenueValue, String sortBy) {
        return (sortBy.equals("Capacity")) ? isLesserThanCapacity(nextIndex, minVenueValue) : false;
    }

    /**
     * Checks if the value at the next index is greater than the provided minimum value for a given sort key
     * @param nextIndex the index of the next element to compare
     * @param minVenueValue the minimum value to compare against (represented as a string)
     * @param sortBy the attribute to compare by (Capacity)
     * @return true if the value at the next index is greater than the minimum value 
     * for the specified sort key, otherwise false
     */
    public static boolean checkGreaterThanForSelection(int nextIndex, String minVenueValue, String sortBy) {
        return (sortBy.equals("Capacity")) ? isGreaterThanCapacity(nextIndex, minVenueValue) : false;

    }

    /**
     * Compares two elements from separate lists based on a given sorting key 
     * and determines if one is lesser than the other
     * @param fCounter the index of the current element in the first list
     * @param sCounter the index of the current element in the second list
     * @param firstHalfVenue the first list of venue models to compare
     * @param secondHalfVenue the second list of venue models to compare
     * @param sortBy the attribute to compare by (Price = rentFee)
     * @return true if the value from the first list is lesser than the value from 
     * the second list, otherwise false
     */
    public static boolean checkLesserThanForMerge(int fCounter, int sCounter, List<VenueModel> firstHalfVenue, List<VenueModel> secondHalfVenue, String sortBy) {
        return (sortBy.equals("Price")) ? isLesserThanPrice(fCounter, sCounter, firstHalfVenue, secondHalfVenue) : false;
    }

    /**
     * Compares two elements from separate lists based on a given sorting key 
     * and determines if one is greater than the other
     * @param fCounter the index of the current element in the first list
     * @param sCounter the index of the current element in the second list
     * @param firstHalfVenue the first list of venue models to compare
     * @param secondHalfVenue the second list of venue models to compare
     * @param sortBy the attribute to compare by (Price = rentFee)
     * @return true if the value from the first list is greater than the value from 
     * the second list, otherwise false
     */
    public static boolean checkGreaterThanForMerge(int fCounter, int sCounter, List<VenueModel> firstHalfVenue, List<VenueModel> secondHalfVenue, String sortBy) {
        return (sortBy.equals("Price")) ? isGreaterThanPrice(fCounter, sCounter, firstHalfVenue, secondHalfVenue) : false;

    }

    /**
     * Retrieves the value of a specific attribute from a VenueModel object
     * based on the sort key
     * @param venue the VenueModel object
     * @param sortBy the attribute to sort by (Id, Name, City, Capacity or Price)
     * @return the value of the specified attribute as a String
     */
    public static String getSortValue(VenueModel venue, String sortBy) {
        return (sortBy.equals("Id")) ? String.valueOf(venue.getVenueId())
                : (sortBy.equals("City")) ? venue.getCity()
                : (sortBy.equals("Name")) ? venue.getVenueName()
                : (sortBy.equals("Capacity")) ? String.valueOf(venue.getCapacity())
                : String.valueOf(venue.getRentFee());

    }

}
