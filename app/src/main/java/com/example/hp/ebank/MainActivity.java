package com.example.hp.ebank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginbuttton;
    EditText user;
    EditText pass;
    final String Userc = "pranav123";
    final String Passc = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findallviews();
        setupalllistner();

    }

        private void findallviews()
        {
            user = (EditText) findViewById(R.id.user);
            pass = (EditText) findViewById(R.id.pass);
            loginbuttton = (Button) findViewById(R.id.loginbuttton);

        }

        private void setupalllistner()
        {
            loginbuttton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String username = user.getText().toString();
                    String password = pass.getText().toString();

                    if(username.equals(Userc) && password.equals(Passc))
                    {
                        Toast loginSuccessToast = Toast.makeText(getApplicationContext(),"Login Done", Toast.LENGTH_LONG);
                        loginSuccessToast.show();
                        Log.d("Button","Correct password");
                        Log.d("Button","Username -: " + username);
                        Log.d("Button","Password -: " + password);

                        Intent launchdetails = new Intent(MainActivity.this,UserAccountActivity.class);
                        launchdetails.putExtra("username",Userc);
                        startActivity(launchdetails);
                    }
                    else
                    {
                        Toast loginFailToast = Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_LONG);
                        loginFailToast.show();
                        Log.d("Button","Incorrect enter again");
                    }
                }
            });
        }

}
