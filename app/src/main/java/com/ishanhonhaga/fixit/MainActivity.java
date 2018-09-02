package com.ishanhonhaga.fixit;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ishanhonhaga.fixit.Utils.Constants;
import com.ishanhonhaga.fixit.lifecycleComponent.MainActivityLifeCycle;
import com.ishanhonhaga.fixit.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView mTextMessage1;
    MainActivityLifeCycle mainActivityLifeCycle;

    private FrameLayout mContainer;

    MainActivityViewModel mainActivityViewModel;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mainActivityLifeCycle.updateView(item.getItemId());
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);

        mContainer = (FrameLayout) findViewById(R.id.container_layout);


        mainActivityViewModel = new MainActivityViewModel();

        //Initialising the LifeCycle Observer
        mainActivityLifeCycle = new MainActivityLifeCycle(this, mainActivityViewModel);


        // Live Data Observer
        mainActivityViewModel.getScreenIndex().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                updateScreen(integer);
                Log.d("INDEX", "Screen index = " + integer);
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    public void updateScreen(int pageIndex) {
        switch (pageIndex) {
            case Constants.COMPLAIN:
                mContainer.findViewById(R.id.complainlayout_1).setVisibility(View.VISIBLE);

                mContainer.findViewById(R.id.complainlayout_2).setVisibility(View.GONE);
                mContainer.findViewById(R.id.complainlayout_3).setVisibility(View.GONE);
                break;
            case Constants.TRACK_COMPLAIN:
                mContainer.findViewById(R.id.complainlayout_2).setVisibility(View.VISIBLE);

                mContainer.findViewById(R.id.complainlayout_1).setVisibility(View.GONE);
                mContainer.findViewById(R.id.complainlayout_3).setVisibility(View.GONE);
                break;
            case Constants.NOTICE_BOARD:
                mContainer.findViewById(R.id.complainlayout_3).setVisibility(View.VISIBLE);

                mContainer.findViewById(R.id.complainlayout_1).setVisibility(View.GONE);
                mContainer.findViewById(R.id.complainlayout_2).setVisibility(View.GONE);
                break;

        }

    }


}
