package com.techelevator;

import java.sql.Date;
import java.time.LocalDate;

public class Reservation {
    private int reservation_id;
    private int space_id;
    private int number_of_attendees;
    private String start_date;
    private String end_date;
    private String reserved_for;

    public Reservation(int space_id, int numberOfAttendees, String from_date, String to_date, String reservedFor) {
        this.space_id = space_id;
        this.number_of_attendees = numberOfAttendees;
        this.start_date = from_date;
        this.end_date = to_date;
        this.reserved_for = reservedFor;
    }
    public Reservation() {
    }
    public int getReservation_id() {
        return reservation_id;
    }
    public int getSpace_id() {
        return space_id;
    }
    public void setSpace_id(int space_id) {
        this.space_id = space_id;
    }

    public int getNumber_of_attendees() {
        return number_of_attendees;
    }

    public void setNumber_of_attendees(int number_of_attendees) {
        this.number_of_attendees = number_of_attendees;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
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
