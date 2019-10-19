package com.github.easymvvm.java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.easymvvm.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Kashif on 9/30/2019.
 */
public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.MyViewHolder> {

    private List<HolidayModel> holidayList;

    public HolidayAdapter() {
        holidayList = new ArrayList<>();
    }

    public void addHolidayList(List<HolidayModel> currencyList) {
        this.holidayList = currencyList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return holidayList != null ? holidayList.size() : 0;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_holiday, parent, false);

        return new MyViewHolder(v);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDate, tvName;

        public MyViewHolder(View convertView) {
            super(convertView);
            tvDate = convertView.findViewById(R.id.tv_date);
            tvName = convertView.findViewById(R.id.tv_name);
        }
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tvDate.setText(holidayList.get(position).getDate());
        holder.tvName.setText(holidayList.get(position).getName());

    }

}
