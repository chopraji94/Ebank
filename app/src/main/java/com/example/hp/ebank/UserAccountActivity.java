package com.example.hp.ebank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserAccountActivity extends AppCompatActivity
{

    Button logoutb;
    Button depositmoney;
    TextView accountbalance;
    TextView welcomemessage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        findAllViews();
        unpack();
        setuplogout();
        setupdeposit();

    }

    private void unpack()
    {
        welcomemessage.setText("Welcome " + getIntent().getStringExtra("username"));
    }

    private void findAllViews()
    {
        logoutb = (Button) findViewById(R.id.logoutb);
        depositmoney = (Button) findViewById(R.id.depositmoney);
        accountbalance = (TextView) findViewById(R.id.accountbalance);
        welcomemessage = (TextView) findViewById(R.id.user_welcome);
    }

    private void setuplogout()
    {
        logoutb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setupdeposit()
    {
        depositmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String balance = accountbalance.getText().toString();
                int numbalance = Integer.valueOf(balance);

                numbalance += 10;

                final String updatedbalance = String.valueOf(numbalance);

                accountbalance.post(new Runnable() {
                    @Override
                    public void run() {
                        accountbalance.setText(updatedbalance);
                    }
                });
            }
        });
    }
}
