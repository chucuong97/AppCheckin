package com.example.hungv.checkinapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hungv.checkinapp.R;
import com.example.hungv.checkinapp.model.ListMenuModel;

import java.util.List;

public class ListMenuAdapter extends BaseAdapter {
    private Context context;
    private int myLayout;
    private List<ListMenuModel> arrayList;

    public ListMenuAdapter(Context context, int myLayout, List<ListMenuModel> arrayList) {
        this.context = context;
        this.myLayout = myLayout;
        this.arrayList = arrayList;
    }

    // tra ve so dong trong list
    @Override
    public int getCount() {

        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    //lay ra layout
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(myLayout, null);
        // anh xa hinh anh va menu
        TextView txtName = convertView.findViewById(R.id.txtmenu);
        ImageView imageView = convertView.findViewById(R.id.imgmenu);

        //truyen vao gia tri
        txtName.setText(arrayList.get(position).getMenu());
        imageView.setImageResource(arrayList.get(position).getImageMenu());
        return convertView;
    }
}
