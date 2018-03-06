package com.zacharykirshbaum.moody.moody;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

//    @Bind(R.id.checkin_button) FloatingActionButton _checkinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_profile);

        // hide/show bottom navigation bar on scroll
//        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
//        layoutParams.setBehavior(new BottomNavigationBehavior());

        toolbar.setTitle(R.string.title_profile);
        loadFragment(new ProfileFragment());

        // start with login activity
//        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

//    @OnClick(R.id.checkin_button)
//    public void onClickCheckinButton() {
//        Log.d("asdf","asdf");
//        Toast.makeText(this, "Checkin in progress!", Toast.LENGTH_LONG).show();
//    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    toolbar.setTitle(R.string.title_profile);
                    loadFragment(new ProfileFragment());
                    return true;
                case R.id.navigation_checkin:
                    toolbar.setTitle(R.string.title_checkin);
                    startActivity(new Intent(MainActivity.this, CheckinActivity.class));
                    return true;
                case R.id.navigation_insights:
                    toolbar.setTitle(R.string.title_insights);
                    loadFragment(new DashboardFragment());
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}