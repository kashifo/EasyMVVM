package com.github.easymvvm.java;

import android.util.Log;

import com.github.easymvvm.commons.ApiInterface;
import com.github.easymvvm.commons.MyApplication;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kashif on 9/27/2019.
 */
public class HolidayRepo {

    private final String TAG = getClass().getSimpleName();
    private MutableLiveData<List<HolidayModel>> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<HolidayModel>> requestHolidays() {

        ApiInterface apiService =
                MyApplication.getRetrofitClient().create(ApiInterface.class);

        apiService.getHolidays().enqueue(new Callback<List<HolidayModel>>() {
            @Override
            public void onResponse(Call<List<HolidayModel>> call, Response<List<HolidayModel>> response) {
                Log.e(TAG, "getCurrencyList response="+response );

                if (response.isSuccessful() && response.body()!=null ) {
                    Log.e(TAG, "requestHolidays response.size="+response.body().size() );
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<HolidayModel>> call, Throwable t) {
                Log.e(TAG, "getProdList onFailure" + call.toString());
            }
        });

        return mutableLiveData;
    }


}
