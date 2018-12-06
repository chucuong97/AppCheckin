package com.example.hungv.checkinapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hungv.checkinapp.R;
import com.example.hungv.checkinapp.model.SpinnerModel;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {
    // phuong thuc constructor
    private Context context;
    private int myLayout;
    private List<SpinnerModel> arrayList;

    public SpinnerAdapter(Context context, int myLayout, List<SpinnerModel> arrayList) {
        this.context = context;
        this.myLayout = myLayout;
        this.arrayList = arrayList;
    }

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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(myLayout, null);
        TextView txtName = (TextView) convertView.findViewById(R.id.txthoinghi);
        txtName.setText(arrayList.get(position).getHoiNghi());

        return convertView;
    }
}
