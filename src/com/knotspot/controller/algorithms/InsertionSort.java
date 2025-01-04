/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knotspot.controller.algorithms;

import com.knotspot.model.VenueModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author eerii
 */
public class InsertionSort {

    private static List<VenueModel> venueArrays;

    public InsertionSort() {
        venueArrays = new ArrayList<>();
    }

    public static void ascendSort(int num[]) {
        for (int i = 1; i < num.length; i++) {
            int current = num[i];
            int previous = i - 1;
            while (previous >= 0 && num[previous] > current) {
                num[previous + 1] = num[previous];
                previous--;
            }
            num[previous + 1] = current;
        }

    }

    public static void VenueSortbyId(List<VenueModel> venueDetails,boolean isAscend) {
        venueArrays.clear();
        venueArrays.addAll(venueDetails);
        for (int i = 1; i < venueArrays.size(); i++) {
            VenueModel currentVenue = venueArrays.get(i);
            int current = currentVenue.getVenueId();
            int previous = i - 1;

            if (isAscend) {
                while (previous >= 0 && venueArrays.get(previous).getVenueId() > current) {
                    venueArrays.set(previous + 1, venueArrays.get(previous));
                    previous--;
                }
            } else {
                while (previous >= 0 && venueArrays.get(previous).getVenueId() < current) {
                    venueArrays.set(previous + 1, venueArrays.get(previous));
                    previous--;
                }
            }

            venueArrays.set(previous + 1, currentVenue);
        }

    }

    public static void VenueSortbyCapacity(List<VenueModel> venueDetails, boolean isAscend) {
        venueArrays.clear();
        venueArrays.addAll(venueDetails);
        for (int i = 1; i < venueArrays.size(); i++) {
            VenueModel currentVenue = venueArrays.get(i);
            int current = currentVenue.getCapacity();
            int previous = i - 1;

            if (isAscend) {
                while (previous >= 0 && venueArrays.get(previous).getCapacity() > current) {
                    venueArrays.set(previous + 1, venueArrays.get(previous));
                    previous--;
                }
            } else {
                while (previous >= 0 && venueArrays.get(previous).getCapacity() < current) {
                    venueArrays.set(previous + 1, venueArrays.get(previous));
                    previous--;
                }
            }
            venueArrays.set(previous + 1, currentVenue);
        }

    }

    public static void VenueSortbyRentFee(List<VenueModel> venueDetails, boolean isAscend) {
        venueArrays.clear();
        venueArrays.addAll(venueDetails);
        for (int i = 1; i < venueArrays.size(); i++) {
            VenueModel currentVenue = venueArrays.get(i);
            int current = currentVenue.getRentFee();
            int previous = i - 1;
            if (isAscend) {
                while (previous >= 0 && venueArrays.get(previous).getRentFee() > current) {
                    venueArrays.set(previous + 1, venueArrays.get(previous));
                    previous--;
                }

            } else {
                while (previous >= 0 && venueArrays.get(previous).getRentFee() > current) {
                    venueArrays.set(previous + 1, venueArrays.get(previous));
                    previous--;
                }
            }
            venueArrays.set(previous + 1, currentVenue);
        }

    }

    public static void main(String[] args) {
        int[] num = {1, 3, 5, 7, 6};
        ascendSort(num);
        System.out.println(Arrays.toString(num));

    }
}
