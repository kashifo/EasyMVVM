package com.github.easymvvm.kotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.easymvvm.R
import com.github.easymvvm.commons.MyApplication
import kotlinx.android.synthetic.main.activity_holiday.*

class HolidayActivityKotlin : AppCompatActivity() {

    val TAG = javaClass.simpleName
    lateinit var holidayAdapterKotlin: HolidayAdapterKotlin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holiday)
        initUI()

        if(MyApplication.getInstance().isNetworkAvailable){
            progressBar.visibility = View.VISIBLE

            val holidayViewModelKotlin = HolidayViewModelKotlin()

            holidayViewModelKotlin.getHolidays().observe(this, object: Observer<List<HolidayModelKotlin>> {

                override fun onChanged(t: List<HolidayModelKotlin>?) {
                    Log.e(TAG, "observe onChanged()="+t?.size )
                    progressBar.setVisibility(View.GONE)
                    holidayAdapterKotlin.addData(t!!)
                    holidayAdapterKotlin.notifyDataSetChanged()
                }

            })

        }else{
            Toast.makeText(this, "No Network Available", Toast.LENGTH_LONG).show()
        }

    }

    fun initUI(){

        rvHolidayList.setHasFixedSize(true);
        val layoutManager = LinearLayoutManager(this)
        rvHolidayList.setLayoutManager(layoutManager)
        rvHolidayList.setItemAnimator(DefaultItemAnimator())

        holidayAdapterKotlin = HolidayAdapterKotlin()
        rvHolidayList.adapter = holidayAdapterKotlin

    }

}
