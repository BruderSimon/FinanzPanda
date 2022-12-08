package com.engel.finanzpanda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.engel.finanzpanda.accounts.Account;
import com.engel.finanzpanda.accounts.AccountsAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Account[] accounts = {
                new Account("+1000", "Sparkasse Rosenheim-Bad Aibling", "https://cdn.nordigen.com/ais/SPK_DACHAU_BYLADEM1DAH.png")
        };

        AccountsAdapter accountsAdapter = new AccountsAdapter(accounts);

        ListView accountsListView = findViewById(R.id.accounts_listview);
        accountsListView.setAdapter(accountsAdapter);



    }

}