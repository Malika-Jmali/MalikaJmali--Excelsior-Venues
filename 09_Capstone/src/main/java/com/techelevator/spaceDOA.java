package com.techelevator;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.text.ParseException;
import java.util.List;

public interface SpaceDOA {
    public List<Space> getSpaceForSelectedVenue(int venue_id);
    public List<Space> getAvailableSpaces(List<String> venue_id) throws ParseException;
    public Space getSpaceForId(int id);
}
