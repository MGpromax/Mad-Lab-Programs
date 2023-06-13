package com.program2.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText LoginUsername, LoginPassword;
    Button btnLogin;
    String user, pass;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginUsername=(EditText)findViewById(R.id.login_username);
        LoginPassword=(EditText)findViewById(R.id.login_password);
        btnLogin=(Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        Bundle bundle=getIntent().getBundleExtra("data");
        user=bundle.getString("User");
        pass=bundle.getString("Pwd");
    }

    @Override
    public void onClick(View v) {
        String user1=LoginUsername.getText().toString();
        String pass1=LoginPassword.getText().toString();
        if(user.equals(user1)&& pass.equals(pass1))
        {
            Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();

        }
        else
        {
            count++;
            if(count==3){
                btnLogin.setEnabled(false);
                Toast.makeText(this,"Failed Login Attempts",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this,"Login Failed" +count,Toast.LENGTH_LONG).show();
            }
        }

    }
}