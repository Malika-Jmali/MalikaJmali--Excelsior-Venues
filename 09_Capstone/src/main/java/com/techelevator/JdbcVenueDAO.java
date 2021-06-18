package com.techelevator;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcVenueDAO implements venueDAO {
    private JdbcTemplate jdbcTemplate;

    public ArrayList<venue> getVenueDetails(int venue_id) {
        ArrayList<venue> venueDetail = new ArrayList<>();
        String Venues = ("SELECT venue.name, venue.description, city.name, city.state_abbreviation, category.name" +
                "FROM category" +
                "JOIN category_venue ON category_venue.category_id = category.id" +
                "WHERE venue.id = category_venue.venue_id;");
        jdbcTemplate.update(Venues, venue_id);
        SqlRowSet results= jdbcTemplate.queryForRowSet(Venues);
        while (results.next()) {
            venueDetail.add(mapRowToVenue(results));
        }
        return venueDetail;
        }


}
