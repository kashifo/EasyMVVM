package com.github.easymvvm.java;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Kashif on 9/27/2019.
 */
public class HolidayViewModel extends ViewModel {

    private HolidayRepo holidayRepo;
    private MutableLiveData<List<HolidayModel>> mutableLiveData;

    public HolidayViewModel(){
        holidayRepo = new HolidayRepo();
    }

    public LiveData<List<HolidayModel>> getHolidays() {
        if(mutableLiveData==null){
            mutableLiveData = holidayRepo.requestHolidays();
        }
        return mutableLiveData;
    }

}
