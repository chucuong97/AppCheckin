package com.example.hungv.checkinapp.model;

import java.sql.Timestamp;

/**
 * Created by chucu on 12/4/2018.
 */

public class Checkin {
    private int id ;
    private String eventID;
    private String guestID;
    private String checkinTime;
    private int duration;
    private int syncStatus;
    private String userName;

    public Checkin(){}

    public Checkin(String eventID, String guestID, String checkinTime, int duration, int syncStatus, String userName) {
        this.eventID = eventID;
        this.guestID = guestID;
        this.checkinTime = checkinTime;
        this.duration = duration;
        this.syncStatus = syncStatus;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(int syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
