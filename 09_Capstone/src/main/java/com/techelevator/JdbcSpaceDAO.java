package com.techelevator;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JdbcSpaceDAO implements SpaceDOA {
    private JdbcTemplate jdbcTemplate;

    public JdbcSpaceDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcSpaceDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Space> getSpaceForSelectedVenue(int venue_id) {
        String getSpaceForSelectedVenue = "SELECT space.id, space.venue_id, space.name, space.is_accessible, space.open_from, space.open_to, CAST(space.daily_rate AS decimal), space.max_occupancy FROM space\n" +
                "WHERE venue_id = ? ;";
        List<Space> spaces = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(getSpaceForSelectedVenue, venue_id);
        while (results.next()) {
            Space space = mapRowToVenue(results);
                spaces.add(space);
        }
        return spaces;
    }
    @Override
    public Space getSpaceForId(int id) {
        String getSpaceForSelectedVenue = "SELECT space.id, space.venue_id, space.name, space.is_accessible, space.open_from, space.open_to, CAST(space.daily_rate AS decimal), space.max_occupancy FROM space\n" +
                "WHERE id = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(getSpaceForSelectedVenue, id);
        Space space = new Space();
        if (results.next()) {
             space = mapRowToVenue(results);
        }
        return space;
    }

    @Override
    public List<Space> getAvailableSpaces(List<String> commands) throws ParseException {
        Date sDate = new SimpleDateFormat("MM/dd/yyyy").parse(commands.get(0));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String sDateString = simpleDateFormat.format(sDate);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        try{
            c.setTime(sdf.parse(commands.get(0)));
        }catch(ParseException e){
            e.printStackTrace();
        }
        c.add(Calendar.DAY_OF_MONTH, Integer.parseInt(commands.get(1)));
        Date eDate = c.getTime();
        String eDateString = simpleDateFormat.format(eDate);
        String getAvailableSpacesSql = "SELECT space.id, space.venue_id, space.name, space.is_accessible, space.open_from, space.open_to, CAST(space.daily_rate AS decimal), space.max_occupancy FROM space " +
                "JOIN venue ON venue.id = space.venue_id " +
                "WHERE venue_id ="+Integer.parseInt(commands.get(3))+
                " AND max_occupancy >= "+Integer.parseInt(commands.get(2))+
                " AND NOT EXISTS (SELECT * FROM reservation " +
                "WHERE (CAST('"+sDateString+ "' AS DATE) BETWEEN reservation.start_date AND reservation.end_date " +
                "OR CAST('"+eDateString+"' AS DATE) BETWEEN reservation.start_date AND reservation.end_date) " +
                "AND reservation.space_id = space.id) " +
                "AND ((EXTRACT(MONTH from CAST('"+sDateString+ "' AS DATE)) BETWEEN space.open_from AND space.open_to) OR space.open_from IS NULL AND space.open_to IS NULL) " +
                "AND ((EXTRACT(MONTH from CAST('"+eDateString+ "' AS DATE)) BETWEEN space.open_from AND space.open_to) OR space.open_from IS NULL AND space.open_to IS NULL) " +
                "GROUP BY space.id " +
                "ORDER BY space.daily_rate ASC " +
                "LIMIT 5";
        List<Space> spaces = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(getAvailableSpacesSql);
        while (results.next()) {
            Space space = mapRowToVenue(results);
            spaces.add(space);
        }
        return spaces;
    }
    private Space mapRowToVenue(SqlRowSet results) {
        Space space = new Space();
        space.setId(results.getInt("id"));
        space.setName(results.getString("name"));
        space.setOpen_from(results.getInt("open_from"));
        space.setOpen_to(results.getInt("open_to"));
        space.setDaily_rate(results.getDouble("daily_rate"));
        space.setMax_occupancy(results.getInt("max_occupancy"));

        return space;

    }
}
