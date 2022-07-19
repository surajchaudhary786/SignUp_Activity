package com.example.signup_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Log_In extends AppCompatActivity implements View.OnClickListener {
    EditText lu,lp;
    Button lb;
    String suser,spswd;
    int count =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        lu = (EditText) findViewById(R.id.user_login);
        lp = (EditText) findViewById(R.id.pswd_login);
        lb = (Button) findViewById(R.id.button_login);
        lb.setOnClickListener(this);
        Bundle bundle = getIntent().getBundleExtra("data");
        suser = bundle.getString("user");
        spswd = bundle.getString("pwd");
    }

    @Override
    public void onClick(View v) {
        String login_un = lu.getText().toString();
        String login_pwd = lp.getText().toString();
        if(suser.equals(login_un) && spswd.equals(login_pwd)){
            Toast.makeText(getBaseContext(),"Login successful",Toast.LENGTH_LONG).show();
        }
        else{
            count++;
            if(count==3){
                lb.setEnabled(false);
                Toast.makeText(getBaseContext(),"Failed Login Attempts",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getBaseContext(),"Login Failed, Try Again !!!",Toast.LENGTH_LONG).show();
            }
        }
    }
}