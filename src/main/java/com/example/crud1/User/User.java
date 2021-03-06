package com.example.crud1.User;

import java.util.Date;
// e9e2cc34-c538-41ec-a5b0-a1f36e7b9e15
public class User {
    private Integer id;

    private String name;

    
    private Date dob;
    
    
    public User() {
    }

    public User(Integer id, String name, Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "dob=" + dob + ", id=" + id + ", name=" + name + "";
    }

    
    
}
