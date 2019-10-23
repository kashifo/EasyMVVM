package com.github.easymvvm.kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Kashif on 10/9/2019.
 */
class HolidayViewModelKotlin() : ViewModel() {

    var holidayRepoKotlin: HolidayRepoKotlin? = null

    init {
        holidayRepoKotlin = HolidayRepoKotlin()
    }

    fun getHolidays(): LiveData<ArrayList<HolidayModelKotlin>> {
        return holidayRepoKotlin!!.fetchHolidays()
    }

}