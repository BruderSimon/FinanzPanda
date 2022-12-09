package com.engel.finanzpanda.accounts;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.engel.finanzpanda.R;

public class AccountsOverviewFragment extends Fragment {

    public AccountsOverviewFragment() {
        super(R.layout.accounts_overview_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Account[] accounts = {
                new Account("+1000", "Sparkasse", "https://cdn.nordigen.com/ais/SPK_DACHAU_BYLADEM1DAH.png"),
                new Account("-54", "N26 Bank", "https://cdn.nordigen.com/ais/N26_SANDBOX_NTSBDEB1.png")
        };

        AccountsAdapter accountsAdapter = new AccountsAdapter(accounts);

        ListView accountsListView = view.findViewById(R.id.accounts_listview);
        accountsListView.setAdapter(accountsAdapter);
    }
}
