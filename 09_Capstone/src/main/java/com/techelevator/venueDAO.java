package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public interface VenueDAO {
    public List<Venue> getAllVenues();
    public Venue getVenueDetails(int venue_id);


}
