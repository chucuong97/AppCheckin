package com.example.hungv.checkinapp.model;


import java.sql.Timestamp;

/**
 * Created by chucu on 12/4/2018.
 */

public class Guest {
    private String eventID;
    private String guestID;
    private String phone;
    private String identifyCardNumber;
    private String registeredTime;
    private int checkinNumber;

    public Guest(){}

    public Guest(String eventID, String guestID, String phone, String identifyCardNumber, String registeredTime, int checkinNumber) {
        this.eventID = eventID;
        this.guestID = guestID;
        this.phone = phone;
        this.identifyCardNumber = identifyCardNumber;
        this.registeredTime = registeredTime;
        this.checkinNumber = checkinNumber;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentifyCardNumber() {
        return identifyCardNumber;
    }

    public void setIdentifyCardNumber(String identifyCardNumber) {
        this.identifyCardNumber = identifyCardNumber;
    }

    public String getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(String registeredTime) {
        this.registeredTime = registeredTime;
    }

    public int getCheckinNumber() {
        return checkinNumber;
    }

    public void setCheckinNumber(int checkinNumber) {
        this.checkinNumber = checkinNumber;
    }
}
