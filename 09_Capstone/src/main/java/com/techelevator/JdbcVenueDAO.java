package com.techelevator;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcVenueDAO implements VenueDOA {


    private JdbcTemplate jdbcTemplate;

    public JdbcVenueDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcVenueDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // TO DO : Build DAO methods here
    @Override
    public List<Venue> getAllVenues() {
        String getAllVenuesSql = "SELECT name fROM venue;";
        List<Venue> venues = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(getAllVenuesSql);
        while (results.next()) {
            Venue venue = mapRowToVenue(results);
            venues.add(venue);
        }
        return venues;
    }

    @Override
    public List<Venue> getVenueDetails(int venue_id) {
        String getVenueDetailsSql = "SELECT distinct category.name, venue.name, venue.description, abbreviation, city.name\n" +
                "FROM venue\n" +
                "JOIN city on venue.city_id = city.id\n" +
                "JOIN state on city.state_abbreviation = state.abbreviation\n" +
                "JOIN category_venue on venue.id = category_venue.venue_id\n" +
                "JOIN category on category_venue.category_id = category.id\n" +
                "JOIN space on space.venue_id = venue.id\n" +
                "JOIN reservation on reservation.space_id = space.id\n" +
                "where venue.id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(getVenueDetailsSql, venue_id);
        List<Venue> venues = new ArrayList<>();
        while (results.next()) {
            Venue venue = mapRowToVenueAll1
                    (results);
            venues.add(venue);
        }
        return venues;
    }

    private Venue mapRowToVenue(SqlRowSet results) {
        Venue venue = new Venue();
        venue.setName(results.getString("name"));
        return venue;

    }
    private Venue mapRowToVenueAll(SqlRowSet results) {
        Venue venue = new Venue();
        venue.setName(results.getString("name"));
        venue.setDescription(results.getString("description"));

        return venue;

    }
}


