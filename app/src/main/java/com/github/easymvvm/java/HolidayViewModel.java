package com.github.easymvvm.java;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Kashif on 9/27/2019.
 */
public class HolidayViewModel extends ViewModel {

    private HolidayRepo holidayRepo;

    public HolidayViewModel(){
        holidayRepo = new HolidayRepo();
    }

    public LiveData<List<HolidayModel>> getHolidays() {
        return holidayRepo.requestHolidays();
    }

}
