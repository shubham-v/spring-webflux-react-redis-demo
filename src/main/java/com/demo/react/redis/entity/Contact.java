package com.demo.react.redis.entity;

import lombok.*;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.*;

@AllArgsConstructor
public class Contact {

    private String name;
    private Set<String> mobiles = new HashSet<>();;
    private Set<String> email = new HashSet<>();;
    private Set<String> address= new HashSet<>();;
    private Date createdOn = new Date();
    private Date updatedOn;
    private boolean isBlocked;
    private int distance;
    private List<String> connectionTrail = new ArrayList<>();;
    private String note;

    public Contact() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getMobiles() {
        return mobiles;
    }

    public void setMobiles(Set<String> mobiles) {
        this.mobiles = mobiles;
    }

    public Set<String> getEmail() {
        return email;
    }

    public void setEmail(Set<String> email) {
        this.email = email;
    }

    public Set<String> getAddress() {
        return address;
    }

    public void setAddress(Set<String> address) {
        this.address = address;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<String> getConnectionTrail() {
        return connectionTrail;
    }

    public void setConnectionTrail(List<String> connectionTrail) {
        this.connectionTrail = connectionTrail;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
