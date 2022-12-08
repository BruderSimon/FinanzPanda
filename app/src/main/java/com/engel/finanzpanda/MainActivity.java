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
                new Account("+1000", "Sparkasse", "https://cdn.nordigen.com/ais/SPK_DACHAU_BYLADEM1DAH.png"),
                new Account("-54", "N26 Bank", "https://cdn.nordigen.com/ais/N26_SANDBOX_NTSBDEB1.png")
        };

        AccountsAdapter accountsAdapter = new AccountsAdapter(accounts);

        ListView accountsListView = findViewById(R.id.accounts_listview);
        accountsListView.setAdapter(accountsAdapter);



    }

}