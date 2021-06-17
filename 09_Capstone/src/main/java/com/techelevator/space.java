package com.techelevator;

import java.math.BigDecimal;

public class space {
    private int id;
    private Integer venue_id;
    private String name;
    private Boolean Is_accessible;
    private int open_from;
    private int open_to;
    private BigDecimal daily_rate;
    private Integer max_occupancy;

    public Integer getId() {
        return id;
    }
    public Integer getVenue_id() {
        return venue_id;
    }

    public String getName() {
        return name;
    }

    public Boolean getIs_accessible() {
        return Is_accessible;
    }


    public int getOpen_from() {
        return open_from;
    }

    public int getOpen_to() {
        return open_to;
    }

    public void setOpen_from(int open_from) {
        this.open_from = open_from;
    }

    public void setOpen_to(int open_to) {
        this.open_to = open_to;
    }

    public BigDecimal getDaily_rate() {
        return daily_rate;
    }
    public void setDaily_rate(BigDecimal daily_rate) {
        this.daily_rate = daily_rate;
    }
    public Integer getMax_occupancy() {
        return max_occupancy;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVenue_id(Integer venue_id) {
        this.venue_id = venue_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIs_accessible(Boolean is_accessible) {
        Is_accessible = is_accessible;
    }

    public void setMax_occupancy(Integer max_occupancy) {
        this.max_occupancy = max_occupancy;
    }


}
