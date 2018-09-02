package com.ishanhonhaga.fixit.Utils;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

public class NavigationListener implements BottomNavigationView.OnNavigationItemSelectedListener {
    int index;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    public interface listeIndex{
        public int getIndex();
    };
}
