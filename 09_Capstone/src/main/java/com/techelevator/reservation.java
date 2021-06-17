package com.techelevator;

import java.sql.Date;

public class reservation {
    private Integer id;
    private Integer space_id;
    private Integer number_of_attendees;
    private java.sql.Date start_date;
    private java.sql.Date end_date;
    private String reserved_for;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public Date getStart_date() {
        return start_date;
    }
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
    public Date getEnd_date() {
        return end_date;
    }
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getReserved_for() {
        return reserved_for;
    }

    public void setReserved_for(String reserved_for) {
        this.reserved_for = reserved_for;
    }
}
