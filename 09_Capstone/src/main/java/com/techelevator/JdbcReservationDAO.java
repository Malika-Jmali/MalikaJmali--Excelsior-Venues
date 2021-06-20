package com.techelevator;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcReservationDAO implements ReservationDAO{
    private JdbcTemplate jdbcTemplate;

    public JdbcReservationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }
    public JdbcReservationDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Reservation addReservation(Reservation reservation) {

        String addReservationSql = "INSERT INTO reservation( space_id, number_of_attendees, start_date, end_date, reserved_for) " +
                "VALUES(?, ?, CAST(? AS DATE), CAST(? AS DATE), ?)";
        jdbcTemplate.update(addReservationSql,
                reservation.getSpace_id(),
                reservation.getNumber_of_attendees(),
                reservation.getStart_date(),
                reservation.getEnd_date(),
                reservation.getReserved_for());
        String addReservationSelectSql = "SELECT reservation_id, space_id, number_of_attendees, start_date, end_date, reserved_for FROM reservation WHERE reserved_for = '"+reservation.getReserved_for()+"';";
        SqlRowSet results = jdbcTemplate.queryForRowSet(addReservationSelectSql);
        Reservation reservationSuccess = new Reservation();
        if (results.next()) {
             reservationSuccess= mapRowToVenue(results);

        }
        return reservationSuccess;

    }

    private Reservation mapRowToVenue(SqlRowSet results) {
        Reservation reservation = new Reservation();
        reservation.setReservation_id(results.getInt("reservation_id"));
        reservation.setSpace_id(results.getInt("space_id"));
        reservation.setNumber_of_attendees(results.getInt("number_of_attendees"));
        reservation.setStart_date(results.getString("Start_date"));
        reservation.setEnd_date(results.getString("end_date"));
        reservation.setReserved_for(results.getString("reserved_for"));
        return reservation;

    }
}


