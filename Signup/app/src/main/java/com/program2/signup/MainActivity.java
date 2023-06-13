package com.program2.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText S_username, S_PASSWORD;
    Button B1;
    String RE="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        S_username=(EditText)findViewById(R.id.txt_username);
        S_PASSWORD=(EditText)findViewById(R.id.txt_password);
        B1=(Button)findViewById(R.id.btn_signup);
        B1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username=S_username.getText().toString();
        String password=S_PASSWORD.getText().toString();
        if(validatePassword(password)){
            Toast.makeText(getBaseContext(),"Valid Password", Toast.LENGTH_LONG).show();
            Bundle bundle=new Bundle();
            bundle.putString("User",username);
            bundle.putString("Pwd",password);
            Intent it=new Intent(this,login.class);
            it.putExtra("data",bundle);
            startActivity(it);
        } else
        {
            Toast.makeText(getBaseContext(),"Invalid Password",Toast.LENGTH_LONG).show();
        }

    }

    private boolean validatePassword(String password) {
        Pattern pattern=Pattern.compile(RE);
        Matcher matcher=pattern.matcher(password);
        return matcher.matches();
    }
}