package com.example.bookwala;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private EditText first_name,last_name,reg_mail,reg_password;
    private Button reg_button;

    private FirebaseAuth mAuth;

    private ProgressDialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();
        mDialog=new ProgressDialog(this);

        first_name=findViewById(R.id.reg_firstname);
        last_name=
    }
}