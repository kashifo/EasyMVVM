package com.github.easymvvm.kotlin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.easymvvm.commons.ApiInterface
import com.github.easymvvm.commons.MyApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Kashif on 10/9/2019.
 */
class HolidayRepoKotlin {

    val TAG = javaClass.simpleName

    fun fetchHolidays(): MutableLiveData<List<HolidayModelKotlin>>{
        var mutableList: MutableLiveData<List<HolidayModelKotlin>> = MutableLiveData()

        val apiInterface = MyApplication.getRetrofitClient().create(ApiInterface::class.java)

        apiInterface.getHolidaysKotlin().enqueue(object: Callback<List<HolidayModelKotlin>>{

            override fun onResponse(call: Call<List<HolidayModelKotlin>>, response: Response<List<HolidayModelKotlin>>) {
                Log.e(TAG, "onResponse response="+response.toString() )

                if(response.isSuccessful){
                    Log.e(TAG, "onResponse response.size="+response.body()?.size )

                    if(response.body()!=null && response.body()?.size!!>0 ) {
                        mutableList.value = response.body()!!
                    }
                }
            }

            override fun onFailure(call: Call<List<HolidayModelKotlin>>, t: Throwable) {
                Log.e(TAG, "onFailure call="+call.toString() )
            }

        })

        return mutableList
    }

}