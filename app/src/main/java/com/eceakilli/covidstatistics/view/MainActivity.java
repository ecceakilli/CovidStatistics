package com.eceakilli.covidstatistics.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.eceakilli.covidstatistics.R;
import com.eceakilli.covidstatistics.databinding.ActivityMainBinding;
import com.eceakilli.covidstatistics.databinding.FragmentCountriesBinding;
import com.eceakilli.covidstatistics.databinding.FragmentWorldBinding;
import com.eceakilli.covidstatistics.fragment.CountriesFragment;
import com.eceakilli.covidstatistics.fragment.WorldFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<WorldFragment> worldFragmentArrayList;
    ArrayList<CountriesFragment> countriesFragmentArrayList;
    private FragmentWorldBinding bindingWorld;
    private FragmentCountriesBinding bindingCountries;
    private ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //------World Binding-----
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        View viewWorld=mainBinding.getRoot();
        setContentView(viewWorld);

        //-----BottomNavigationView
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnItemSelectedListener(navListener);
        //başlangıçca hangi pencerenin gelmesini istiyorsam secimini yapıyorum
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view,new WorldFragment()).commit();
    }
    private NavigationBarView.OnItemSelectedListener navListener= new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;
                switch (item.getItemId()){
                    case R.id.world:
                        selectedFragment=new WorldFragment();
                        break;
                    case R.id.countries:
                        selectedFragment=new CountriesFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view,selectedFragment).commit();

                return true;
        }
    };


}