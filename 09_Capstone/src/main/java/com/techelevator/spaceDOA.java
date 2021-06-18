package com.techelevator;
import java.util.List;

public interface SpaceDOA {
    public List<Space> getSpaceForSelectedVenue(int venue_id);
    public List<Space> getAvailableSpaces(int venue_id);

}
