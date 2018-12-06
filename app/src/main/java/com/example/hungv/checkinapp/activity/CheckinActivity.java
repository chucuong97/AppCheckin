package com.example.hungv.checkinapp.activity;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.hungv.checkinapp.R;

public class CheckinActivity extends AppCompatActivity {

    Toolbar toolbar;
    private TextView tv_name;
    private TextView tv_cmnd;
    private TextView tv_phoneNumber;
    private TextView tv_checkinNumber;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);
        toolbar =  findViewById(R.id.toolbarCheckin);
        drawerLayout = findViewById(R.id.drawerlayout);
        loadView();
    }

    private void loadView() {
        tv_name =  findViewById(R.id.txt_name);
        tv_cmnd =  findViewById(R.id.txt_cmnd);
        tv_phoneNumber = findViewById(R.id.txt_phoneNumber);
        tv_checkinNumber = findViewById(R.id.txt_checkinNumber);
        ActionBar();
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


}
