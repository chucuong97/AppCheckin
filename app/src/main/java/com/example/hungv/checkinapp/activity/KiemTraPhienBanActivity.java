package com.example.hungv.checkinapp.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.hungv.checkinapp.R;
import com.example.hungv.checkinapp.adapter.ListMenuAdapter;
import com.example.hungv.checkinapp.model.ListMenuModel;

import java.util.ArrayList;

public class KiemTraPhienBanActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ListView listViewmanhinhthietlap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiem_tra_phien_ban);
        toolbar = findViewById(R.id.toolbarmanhinhkiemtraphienban);
        drawerLayout = findViewById(R.id.drawerlayout);
        listViewmanhinhthietlap = findViewById(R.id.listviewmanhinhthietlap);
        drawerLayout = findViewById(R.id.drawerlayout);
        ArrayList<ListMenuModel> arrayList1 = new ArrayList<ListMenuModel>();
        arrayList1.add(new ListMenuModel("Thiết Lập", R.drawable.thietlap));
        arrayList1.add(new ListMenuModel("Lịch Sử Soát", R.drawable.history));
        arrayList1.add(new ListMenuModel("Đăng Xuất", R.drawable.signout));
        arrayList1.add(new ListMenuModel("Kiểm Tra Phiên Bản", R.drawable.kiemtraphienban));
        ListMenuAdapter listMenuAdapter = new ListMenuAdapter(this, R.layout.dong_listview, arrayList1);
        listViewmanhinhthietlap.setAdapter(listMenuAdapter);

        ActionBar();
        CatchOnItemListView();
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

    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ĐĂNG XUẤT");
        builder.setMessage("Bạn có muốn đăng xuất không?");
        builder.setCancelable(false);
        builder.setPositiveButton("KHÔNG", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                //KO THOAT
            }
        });
        builder.setNegativeButton("Đăng xuất", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent2 = new Intent(KiemTraPhienBanActivity.this, MainActivity.class);
                startActivity(intent2);
                drawerLayout.closeDrawer(GravityCompat.START);
                //THOÁT
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void CatchOnItemListView() {
        listViewmanhinhthietlap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(KiemTraPhienBanActivity.this, ThietLapActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        Intent intent1 = new Intent(KiemTraPhienBanActivity.this, LichSuSoatActivity.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        showAlertDialog();
                        break;
                    case 3:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }
}
