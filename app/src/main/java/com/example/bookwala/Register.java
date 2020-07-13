package com.example.bookwala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private EditText first_name,last_name,reg_mail,reg_password,reg_reenterpassword;
    private Button reg_button;

    private FirebaseAuth mAuth;

    private ProgressDialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();
        mDialog=new ProgressDialog(this);

        final DatabaseHelper databaseHelper = new DatabaseHelper(); // Object of class to store user information.

        first_name=findViewById(R.id.reg_firstname);
        last_name=findViewById(R.id.reg_lastname);
        reg_mail=findViewById(R.id.reg_email);
        reg_password=findViewById(R.id.reg_password);
        reg_reenterpassword=findViewById(R.id.reg_reenterpassword);
        reg_button=findViewById(R.id.register_button);

        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mFirstname=first_name.getText().toString().trim();
                final String mLastname=last_name.getText().toString().trim();
                final String mEmail=reg_mail.getText().toString().trim();
                String mPass=reg_password.getText().toString().trim();
                String mRePass=reg_reenterpassword.getText().toString().trim();

                Log.d("here", "Register: ");

                if (TextUtils.isEmpty(mFirstname)){
                    first_name.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(mLastname)){
                    last_name.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(mEmail)){
                    reg_mail.setError("Required Field..");
                    return;
                }
                if(!mEmail.contains("@") || !mEmail.contains(".com"))
                {
                    reg_mail.setError("Enter Vaild Email");
                    return;
                }
                if (TextUtils.isEmpty(mPass)){
                    reg_password.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(mRePass)){
                    reg_reenterpassword.setError("Required Field..");
                    return;
                }
                if (!mPass.equals(mRePass))
                {
                    reg_reenterpassword.setError("Password does not match");
                    return;
                }

                mDialog.setMessage("Processing..");
                mDialog.show();
                Log.d("show", "onClick: " + mEmail + " " + mPass + " " + mRePass);
                mAuth.createUserWithEmailAndPassword(mEmail,mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();

                            Log.d("here", "onComplete: ");
                            databaseHelper.add_user_details(1 , mFirstname , mLastname , mEmail);
                            Log.d("here", "onComplete: ");
                            mDialog.dismiss();
                        }
                        else{
                            Log.d("here", "onComplete: Failure");
                            Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();
                        }
                    }
                });
            }
        });


    }
}