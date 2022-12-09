package com.engel.finanzpanda.accounts;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.engel.finanzpanda.R;

import java.io.InputStream;
import java.net.URL;

public class AccountsAdapter extends BaseAdapter {
    Account[] accounts;

    public AccountsAdapter(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public int getCount() {
        return accounts.length;
    }

    @Override
    public Object getItem(int i) {
        return accounts[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        Account account = accounts[i];

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //...and use it to render Layout XML in view structure
            view = inflater.inflate(R.layout.accounts_item_v2, null, false);
        }

        TextView accountBalance = view.findViewById(R.id.account_balance);
        accountBalance.setText(account.balance);
        if (account.balance.charAt(0) == '-') {
            accountBalance.setTextColor(ContextCompat.getColor(context, R.color.imperia_red));
        } else {
            accountBalance.setTextColor(ContextCompat.getColor(context, R.color.lime_green));
        }

        TextView accountName = view.findViewById(R.id.account_name);
        accountName.setText(account.name);

        //TextView accountInfo = view.findViewById(R.id.account_additonal_info);
        //accountInfo.setText("IBAN: ");

        ImageView accountLogo = view.findViewById(R.id.imageView);
        //Todo Async Class for all Networking
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            accountLogo.setImageDrawable(getNetworkImage(account.logo_link));
        }

        return view;
    }


    private Drawable getNetworkImage(String link) {
        try {
            InputStream is = (InputStream) new URL(link).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            System.out.println("Account Image Error");
            e.printStackTrace();
            return null;
        }
    }
}
