package com.github.easymvvm.commons;

import com.github.easymvvm.java.HolidayModel;
import com.github.easymvvm.kotlin.HolidayModelKotlin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Kashif on 9/27/2019.
 */
public interface ApiInterface {

    @GET("PublicHolidays/2019/us")
    Call<List<HolidayModel>> getHolidays();

    @GET("PublicHolidays/2019/us")
    Call<List<HolidayModelKotlin>> getHolidaysKotlin();

}
