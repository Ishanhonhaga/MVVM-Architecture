package com.ishanhonhaga.fixit.lifecycleComponent;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;

import com.ishanhonhaga.fixit.R;
import com.ishanhonhaga.fixit.Utils.Constants;
import com.ishanhonhaga.fixit.viewModel.MainActivityViewModel;

public class MainActivityLifeCycle implements LifecycleObserver {
    MainActivityViewModel mainActivityViewModel;
    LifecycleOwner owner;
    Context mContext;

    public MainActivityLifeCycle(LifecycleOwner owner, MainActivityViewModel mainActivityViewModel) {
        this.owner = owner;
        owner.getLifecycle().addObserver(this);
        this.mainActivityViewModel = mainActivityViewModel;
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void initView() {
        updateView(mainActivityViewModel.getScreenIndex().getValue());
    }

    public void updateView(int viewID) {
        switch (viewID) {
            case R.id.navigation_complain:
                mainActivityViewModel.setScreenIndex(Constants.COMPLAIN);
                break;
            case R.id.navigation_tracker:
                mainActivityViewModel.setScreenIndex(Constants.TRACK_COMPLAIN);
                break;
            case R.id.navigation_notice:
                mainActivityViewModel.setScreenIndex(Constants.NOTICE_BOARD);
                break;
        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void saveView() {
    }


}
