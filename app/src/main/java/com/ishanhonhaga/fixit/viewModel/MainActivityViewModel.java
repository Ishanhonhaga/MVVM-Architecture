package com.ishanhonhaga.fixit.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    MutableLiveData<Integer> screenIndex;

    public MainActivityViewModel() {
        screenIndex = new MutableLiveData<>();
        screenIndex.setValue(0);
    }

    public LiveData<Integer> getScreenIndex() {
        return screenIndex;
    }

    public void setScreenIndex(int index) {
        screenIndex.postValue(index);
    }

}
