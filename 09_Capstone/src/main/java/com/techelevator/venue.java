package com.techelevator;

import java.util.List;

public class Venue {
    private int id;
    private String name;
    private int city_id;
    private String description;
    private List<String> categoryList;
    public Venue(){
    }
    public List<String> getCategoryList() {
        return categoryList;
    }
    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
