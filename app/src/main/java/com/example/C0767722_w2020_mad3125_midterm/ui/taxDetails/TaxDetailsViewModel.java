package com.example.C0767722_w2020_mad3125_midterm.ui.taxDetails;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TaxDetailsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TaxDetailsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}