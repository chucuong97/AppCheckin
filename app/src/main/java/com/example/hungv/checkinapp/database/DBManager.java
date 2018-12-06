package com.example.hungv.checkinapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.hungv.checkinapp.model.Checkin;
import com.example.hungv.checkinapp.model.Guest;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by chien on 11/13/16.
 */

public class DBManager extends SQLiteOpenHelper {

    public  static final  String DATABASE_NAME ="dbCheckIn";

    private static final String TABLE_GUEST ="guest";
    private static final String EVENT_ID ="eventId";
    private static final String GUEST_ID ="guestId";
    private static final String PHONE ="phone";
    private static final String IDENTIFY_CARD_NUMBER ="identifyCardNumber";
    private static final String REGISTERED_TIME ="registeredTime";
    private static final String CHECKEDIN_NUMBER ="checkedInNumber";

    private  static final String ID = "id";
    private static final String TABLE_CHECKIN ="checkIn";
    private static final String CHECKIN_TIME ="checkInTime";
    private static final String DIRECTION ="direction";
    private static final String SYNC_STATUS ="synsStatus";
    private static final String USER_NAME ="userName";


    private Context context;

    public DBManager(Context context) {
        super(context, DATABASE_NAME,null, 1);
        Log.d("DBManager", "DBManager: ");
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableGuest= "CREATE TABLE IF NOT EXISTS "+TABLE_GUEST +" (" +
                EVENT_ID +" TEXT , "+
                GUEST_ID +" TEXT , "+
                PHONE +" TEXT, "+
                IDENTIFY_CARD_NUMBER+" TEXT,"+
                REGISTERED_TIME+" DATETIME,"+
                CHECKEDIN_NUMBER +" INTEGER, PRIMARY KEY ("+
                EVENT_ID +","+
                GUEST_ID +"))";
        db.execSQL(createTableGuest);

        String createTableCheckIn= "CREATE TABLE IF NOT EXISTS "+TABLE_CHECKIN +" (" +
                ID +" INTEGER PRIMARY KEY, "+
                EVENT_ID +" TEXT, "+
                GUEST_ID + " TEXT, "+
                CHECKIN_TIME +" DATETIME, "+
                DIRECTION+" INTEGER,"+
                SYNC_STATUS+" INTEGER,"+
                USER_NAME +" TEXT)";
        db.execSQL(createTableCheckIn);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_GUEST);
        onCreate(db);
    }

    //Add new Guest
    public void addGuest(Guest guest){
        if(!checkRowGuest(guest.getEventID(),guest.getGuestID())){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(EVENT_ID, guest.getEventID());
            values.put(GUEST_ID, guest.getGuestID());
            values.put(PHONE, guest.getPhone());
            values.put(IDENTIFY_CARD_NUMBER, guest.getIdentifyCardNumber());
            values.put(REGISTERED_TIME, guest.getRegisteredTime());
            values.put(CHECKEDIN_NUMBER, guest.getCheckinNumber());

            db.insert(TABLE_GUEST,null,values);
            db.close();
        }
    }

    //Add new Checkin
    public void addCheckin(Checkin checkin){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EVENT_ID, checkin.getEventID());
        values.put(GUEST_ID, checkin.getGuestID());
        values.put(CHECKIN_TIME, checkin.getCheckinTime());
        values.put(DIRECTION, checkin.getDuration());
        values.put(SYNC_STATUS, checkin.getSyncStatus());
        values.put(USER_NAME, checkin.getUserName());

        db.insert(TABLE_CHECKIN,null,values);
        db.close();
    }


    public ArrayList<Guest> getAllGuest() {
        ArrayList<Guest> listGuest = new ArrayList<Guest>();
        String selectQuery = "SELECT  * FROM " + TABLE_GUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Guest g = new Guest();
                g.setEventID(cursor.getString(0));
                g.setGuestID(cursor.getString(1));
                g.setPhone(cursor.getString(2));
                g.setIdentifyCardNumber(cursor.getString(3));
                g.setRegisteredTime(cursor.getString(4));
                g.setCheckinNumber(cursor.getInt(5));
                listGuest.add(g);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listGuest;
    }

    public ArrayList<Checkin> getAllCheckin() {
        ArrayList<Checkin> listCheckin = new ArrayList<Checkin>();

        String selectQuery = "SELECT  * FROM " + TABLE_CHECKIN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Checkin c = new Checkin();
                c.setId(cursor.getInt(0));
                c.setEventID(cursor.getString(1));
                c.setGuestID(cursor.getString(2));
                c.setCheckinTime(cursor.getString(3));
                c.setDuration(cursor.getInt(4));
                c.setSyncStatus(cursor.getInt(5));
                c.setUserName(cursor.getString(6));
                listCheckin.add(c);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listCheckin;
    }

    public int getGuestCount() {
        String countQuery = "SELECT  * FROM " + TABLE_GUEST;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        if (cursor != null){
            int count = cursor.getCount();
            cursor.close();
            return count;
        }else{
            cursor.close();
            return 0;
        }
    }

    public int getCheckinCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CHECKIN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        if (cursor != null){
            int count = cursor.getCount();
            cursor.close();
            return count;
        }else{
            cursor.close();
            return 0;
        }
    }

    public boolean checkRowGuest(String eventID, String guestID){
        String sql = "SELECT  * FROM " + TABLE_GUEST + " WHERE "+ EVENT_ID + " = '" + eventID + "' AND " + GUEST_ID + " = '"+ guestID +"'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if(cursor.getCount() == 0){
            cursor.close();
            db.close();
            return false;
        }
        cursor.close();
        db.close();
        return true;
    }

}

