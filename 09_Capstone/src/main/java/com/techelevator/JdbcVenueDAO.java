package com.techelevator;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcVenueDAO implements venueDAO {
    private JdbcTemplate jdbcTemplate;
    public JdbcVenueDAO (DataSource dataSource){
        this.jdbcTemplate -new JdbcTemplate(dataSource);
    }

    public List<venue> getAll() {
        List<venue> venues = new ArrayList<>();
        String sqlGetAllVenues = "Select id, name From venue";
        SqlRowSet results = jdbcTemplate.queryForRowSet(SqlGetAllVenues);
        while (results.next()) {
            venue theVenue = mapRowToVenue(results);
            venues.add(theVenue);

        }
        return venues;
    }
    private venue mapRowToVenue(SqlRowSet results) {
        venue theVenue;
        theVenue = new venue();
        theVenue.setId(results.getInt("id"));
        theVenue.setName(results.getString("name"));
        return theVenue;
    }


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

        @Override
    public List<venue> getVenueByID(String venueID, String name){
        return null;
        }

}
