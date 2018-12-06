package com.example.hungv.checkinapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hungv.checkinapp.R;
import com.example.hungv.checkinapp.model.Guest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Welcome on 8/27/2016.
 */
public class AdapterGuest extends ArrayAdapter<Guest> {

    private Context context;
    private int resource;
    private List<Guest> arrGuest;

    public AdapterGuest(Context context, int resource, ArrayList<Guest> arrGuest) {
        super(context, resource, arrGuest);
        this.context = context;
        this.resource = resource;
        this.arrGuest = arrGuest;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvGuestID = (TextView) convertView.findViewById(R.id.txt_guestID);
            viewHolder.tvEventID = (TextView) convertView.findViewById(R.id.txt_eventID);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Guest guest = arrGuest.get(position);
        viewHolder.tvGuestID.setText(guest.getGuestID());
        viewHolder.tvEventID.setText(guest.getEventID());
        return convertView;
    }

    public class ViewHolder {
        TextView tvEventID;
        TextView tvGuestID;
    }
}
