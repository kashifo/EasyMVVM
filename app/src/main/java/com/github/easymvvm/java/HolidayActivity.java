package com.github.easymvvm.java;

import android.os.Bundle;
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

    ProgressBar progressBar;
    HolidayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);
        initUI();

        if(MyApplication.getInstance().isNetworkAvailable()) {

            HolidayViewModel holidayViewModel = new HolidayViewModel();
            holidayViewModel.getHolidays().observe(this, new Observer<List<HolidayModel>>() {
                @Override
                public void onChanged(List<HolidayModel> currencyPojos) {
                    progressBar.setVisibility(View.GONE);
                    adapter.addHolidayList(currencyPojos);
                }
            });

        }else{
            Toast.makeText(this, "No Network Available", Toast.LENGTH_LONG).show();
        }
    }

    void initUI(){
        RecyclerView rvCurrencyList = findViewById(R.id.rvCurrencyList);
        rvCurrencyList.setHasFixedSize(true);
        rvCurrencyList.setLayoutManager(new LinearLayoutManager(this));

        adapter = new HolidayAdapter();
        rvCurrencyList.setAdapter(adapter);

        progressBar = findViewById(R.id.progressBar);
    }

}
