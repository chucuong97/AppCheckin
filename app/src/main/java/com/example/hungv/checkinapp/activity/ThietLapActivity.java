package com.example.hungv.checkinapp.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.NavigationView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hungv.checkinapp.R;
import com.example.hungv.checkinapp.adapter.ListMenuAdapter;
import com.example.hungv.checkinapp.model.ListMenuModel;
import com.example.hungv.checkinapp.model.SpinnerModel;

import java.util.ArrayList;


public class ThietLapActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Spinner spinnerSuKienCanSoat;
    private ListView listViewmanhinhthietlap;

    private TextView txt_rowNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thietlap);
        loadView();
        loadEvents();
        loadMenuMode();
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
                Intent intent2 = new Intent(ThietLapActivity.this, MainActivity.class);
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
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        Intent intent1 = new Intent(ThietLapActivity.this, LichSuSoatActivity.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        showAlertDialog();
                        break;
                    case 3:
                        Intent intent3 = new Intent(ThietLapActivity.this, KiemTraPhienBanActivity.class);
                        startActivity(intent3);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }
        });
    }

    private void loadView(){
        listViewmanhinhthietlap = findViewById(R.id.listviewmanhinhthietlap);
        toolbar = findViewById(R.id.toolbarmanhinhthietlap);
        navigationView = findViewById(R.id.navigationview);
        drawerLayout = findViewById(R.id.drawerlayout);
        spinnerSuKienCanSoat = findViewById(R.id.drop_down);

        txt_rowNumber = findViewById(R.id.txt_rowNumber);
        txt_rowNumber.setText(String.valueOf(MainActivity.listGuest.size()));
    }

    private void loadEvents(){
        ArrayList<SpinnerModel> arrayList = new ArrayList<SpinnerModel>();
        arrayList.add(new SpinnerModel("Hội Nghị An Ninh Mạng "));
        arrayList.add(new SpinnerModel("Hội Nghị An Toàn Thông Tin "));
        arrayList.add(new SpinnerModel("Hội Nghị Ngân Hàng Nhà Nước "));
        arrayList.add(new SpinnerModel("Hội Nghị Toán Học "));
        arrayList.add(new SpinnerModel("Hội Nghị Khoa Học Hạt Nhân "));
        arrayList.add(new SpinnerModel("Hội Nghị Phát Triên Ngân Hàng Số "));
        arrayList.add(new SpinnerModel("Hội Nghị Bảo Mật Thông Tin "));
        com.example.hungv.checkinapp.adapter.SpinnerAdapter spinnerAdapter = new com.example.hungv.checkinapp.adapter.SpinnerAdapter
                (this, R.layout.list_spinner, arrayList);
        spinnerSuKienCanSoat.setAdapter(spinnerAdapter);
    }

    private void loadMenuMode(){
        ArrayList<ListMenuModel> arrayList1 = new ArrayList<ListMenuModel>();

        arrayList1.add(new ListMenuModel("Thiết Lập", R.drawable.thietlap));
        arrayList1.add(new ListMenuModel("Lịch Sử Soát", R.drawable.history));
        arrayList1.add(new ListMenuModel("Đăng Xuất", R.drawable.signout));
        arrayList1.add(new ListMenuModel("Kiểm Tra Phiên Bản", R.drawable.kiemtraphienban));
        ListMenuAdapter listMenuAdapter = new ListMenuAdapter(this, R.layout.dong_listview, arrayList1);
        listViewmanhinhthietlap.setAdapter(listMenuAdapter);
    }

}
