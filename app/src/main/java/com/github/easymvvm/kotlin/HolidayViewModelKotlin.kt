package com.github.easymvvm.kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Kashif on 10/9/2019.
 */
class HolidayViewModelKotlin() : ViewModel() {

    var holidayRepoKotlin: HolidayRepoKotlin? = null
    var mutableLiveData: MutableLiveData<List<HolidayModelKotlin>>? = null

    init {
        holidayRepoKotlin = HolidayRepoKotlin()
    }

    fun getHolidays(): LiveData<List<HolidayModelKotlin>> {
        if (mutableLiveData == null) {
            mutableLiveData = holidayRepoKotlin!!.fetchHolidays()
        }
        return mutableLiveData!!
    }

}