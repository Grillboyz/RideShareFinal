package com.example.eddy.updatedrideshare;

import java.util.ArrayList;

/**
 * Created by e-sal on 4/24/2017.
 */

public class RideListings {

    private static ArrayList<RidePosting> rideListings = new ArrayList<RidePosting>();

    public void setArray(ArrayList<RidePosting> theRides) {
        rideListings = theRides;
    }

    public ArrayList<RidePosting> getArray() {
        return rideListings;
    }
}


