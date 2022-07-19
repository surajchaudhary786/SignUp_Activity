package com.example.signup_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;suraj

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText su,sp;
    Button sb;
    String re = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        su = (EditText) findViewById(R.id.user_signup);
        sp = (EditText) findViewById(R.id.pswd_signup);
        sb = (Button) findViewById(R.id.button_signup);
        sb.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String s_un = su.getText().toString();
        String s_pswd = sp.getText().toString();
        if(validatePassword(s_pswd)){
            Bundle bundle = new Bundle();
            bundle.putString("user",s_un);
            bundle.putString("pwd",s_pswd);
            Intent it = new Intent(this,Log_In.class);
            it.putExtra("data",bundle);
            startActivity(it);
        }
        else{
            Toast.makeText(getBaseContext(),"Invalid Password",Toast.LENGTH_LONG).show();
        }
    }

    private boolean validatePassword(String s_pswd) {
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(s_pswd);
        return matcher.matches();

    }
}