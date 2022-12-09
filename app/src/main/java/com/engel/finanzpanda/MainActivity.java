package com.engel.finanzpanda;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.engel.finanzpanda.accounts.AccountsOverviewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        AccountsOverviewFragment accountsOverview = new AccountsOverviewFragment();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.account_overview:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_view, accountsOverview).commit();
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.account_overview);
        bottomNavigationView.setItemActiveIndicatorColor(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.lime_green)));
        bottomNavigationView.setItemActiveIndicatorEnabled(true);


    }

}