package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.venue;
public interface venueDAO {
    public List<venue> getAll();
    public ArrayList<venue> getVenueDetails(int venue_id);
    public List<venue> getVenueById(String venueId,String name);


}
