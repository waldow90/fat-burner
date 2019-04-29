package edu.stts.fatburner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import edu.stts.fatburner.classObject.Food;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNav;
    public static final int CODE_INFOFOOD = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Fat Burner");

        //Untuk Navigation
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Untuk bottom navigation
        bottomNav = findViewById(R.id.main_bnav);
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Set Default biar menu home ditampilkan duluan
        loadFragment(new HomeFragment());
    }

    //Event saat button navigation diclick
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.bnav_diary:
                    setTitle("Diary");
                    fragment = new DiaryFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.bnav_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.bnav_report:
                    setTitle("Reports");
                    fragment = new ReportsFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    //Untuk ganti fragment pada main activity
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == CODE_INFOFOOD){
            if(resultCode == Activity.RESULT_OK){
                Food food = (Food) data.getExtras().getSerializable("food_data");
                Toast.makeText(this,String.valueOf(Integer.parseInt(food.getKalori())* food.getJumlah()),Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_diary) {
            setTitle("Diary");
            loadFragment(new DiaryFragment());
        } else if (id == R.id.nav_home) {
            setTitle("Home");
            loadFragment(new HomeFragment());
        } else if (id == R.id.nav_plans) {
            Intent i = new Intent(MainActivity.this,GraphicActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_report) {
            setTitle("Reports");
            loadFragment(new ReportsFragment());
        } else if (id == R.id.nav_settings) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
