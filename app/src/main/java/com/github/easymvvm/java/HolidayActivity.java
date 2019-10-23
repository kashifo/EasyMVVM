package com.github.easymvvm.java;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.easymvvm.R;
import com.github.easymvvm.commons.MyApplication;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HolidayActivity extends AppCompatActivity {

    final String TAG = getClass().getSimpleName();
    ProgressBar progressBar;
    HolidayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);
        initUI();

        if(MyApplication.getInstance().isNetworkAvailable()) {
            progressBar.setVisibility(View.VISIBLE);

            HolidayViewModel holidayViewModel = new HolidayViewModel();
            holidayViewModel.getHolidays().observe(this, new Observer<List<HolidayModel>>() {
                @Override
                public void onChanged(List<HolidayModel> currencyPojos) {
                    if(currencyPojos!=null && !currencyPojos.isEmpty()) {
                        Log.e(TAG, "observe onChanged()="+currencyPojos.size() );
                        progressBar.setVisibility(View.GONE);
                        adapter.addHolidayList(currencyPojos);
                        adapter.notifyDataSetChanged();
                    }
                }
            });

        }else{
            Toast.makeText(this, "No Network Available", Toast.LENGTH_LONG).show();
        }
    }

    void initUI(){
        RecyclerView rvHolidayList = findViewById(R.id.rvHolidayList);
        rvHolidayList.setHasFixedSize(true);
        rvHolidayList.setLayoutManager(new LinearLayoutManager(this));

        adapter = new HolidayAdapter();
        rvHolidayList.setAdapter(adapter);

        progressBar = findViewById(R.id.progressBar);
    }

}
