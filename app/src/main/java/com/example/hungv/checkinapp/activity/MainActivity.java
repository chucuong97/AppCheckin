package com.example.hungv.checkinapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hungv.checkinapp.R;
import com.example.hungv.checkinapp.database.DBManager;
import com.example.hungv.checkinapp.model.Checkin;
import com.example.hungv.checkinapp.model.Guest;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button dangNhap;
    private EditText userName, passWord;
    int COUNTER = 3;

    private final DBManager db = new DBManager(this);
    public static ArrayList<Guest> listGuest;
    public static ArrayList<Checkin> listCheckin;
    public static int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadView();
        dangNhap();
        loadDatabase();
        listGuest = db.getAllGuest();
        listCheckin = db.getAllCheckin();
    }
    private void loadView() {
        dangNhap = findViewById(R.id.btnDangNhap);
        userName = findViewById(R.id.edtUserName);
        passWord = findViewById(R.id.edtPassWord);
    }

    private void dangNhap(){
        dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().equals("1") && passWord.getText().toString().equals("1")) {
                    // Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, ThietLapActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Username hoặc Password không hợp lệ", Toast.LENGTH_SHORT).show();
                    userName.setVisibility(View.VISIBLE);
                    COUNTER--;
                    if (COUNTER == 0) {
                        dangNhap.setEnabled(false);
                    }
                }
            }
        });
    }

    public void loadDatabase(){
        if (db.getGuestCount() <= 0){
            Guest g1 = new Guest("E1","G1","Phone","CMND","Date",0);
            Guest g2 = new Guest("E1","G2","Phone","CMND","Date",0);
            Guest g3 = new Guest("E1","G3","Phone","CMND","Date",0);
            Guest g4 = new Guest("E1","G4","Phone","CMND","Date",0);
            Guest g5 = new Guest("E1","G5","Phone","CMND","Date",0);

            db.addGuest(g1);
            db.addGuest(g2);
            db.addGuest(g3);
            db.addGuest(g4);
            db.addGuest(g5);
            for (int i = 0; i <5 ; i++) {
                Checkin c = new Checkin("E1","G1","Date",0,0,"Chu cuong");
                db.addCheckin(c);
            }
        }
    }

}

