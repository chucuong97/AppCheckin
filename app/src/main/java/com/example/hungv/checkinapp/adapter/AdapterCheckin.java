package com.example.hungv.checkinapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hungv.checkinapp.R;
import com.example.hungv.checkinapp.model.Checkin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Welcome on 8/27/2016.
 */
public class AdapterCheckin extends ArrayAdapter<Checkin> {

    private Context context;
    private int resource;
    private List<Checkin> arrCheckin;

    public AdapterCheckin(Context context, int resource, ArrayList<Checkin> arrCheckin) {
        super(context, resource, arrCheckin);
        this.context = context;
        this.resource = resource;
        this.arrCheckin = arrCheckin;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_layout_checkin, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvID = (TextView) convertView.findViewById(R.id.txt_checkinID);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.txt_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Checkin c = arrCheckin.get(position);
        viewHolder.tvID.setText(String.valueOf(c.getId()));
        viewHolder.tvName.setText(c.getUserName());
        return convertView;
    }

    public class ViewHolder {
        TextView tvID;
        TextView tvName;
    }
}
