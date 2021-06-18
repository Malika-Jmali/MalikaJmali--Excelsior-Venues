package com.techelevator;

import java.sql.Date;
import java.time.LocalDate;

public class Reservation {
    private int reservation_id;
    private int space_id;
    private int number_of_attendees;
    private LocalDate start_date;
    private LocalDate end_date;
    private String reserved_for;

    public Reservation(int space_id, int numberOfAttendees, LocalDate from_date, LocalDate to_date, String reservedFor) {
    }

    public Integer getReservation_id() {
        return reservation_id;
    }
    public void setReservation_id(Integer reservation_id) {
        this.reservation_id = reservation_id;
    }
    public Integer getSpace_id() {
        return space_id;
    }
    public void setSpace_id(Integer space_id) {
        this.space_id = space_id;
    }

    public Integer getNumber_of_attendees() {
        return number_of_attendees;
    }

    public void setNumber_of_attendees(Integer number_of_attendees) {
        this.number_of_attendees = number_of_attendees;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public String getReserved_for() {
        return reserved_for;
    }

    public void setReserved_for(String reserved_for) {
        this.reserved_for = reserved_for;
    }

    public void setReservationId(int reservation_id) {
    }


}
