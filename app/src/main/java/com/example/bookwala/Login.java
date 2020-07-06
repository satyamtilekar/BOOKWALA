package com.example.bookwala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText log_email , log_password ;
    private Button login_button;
    private TextView signUp;
    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }

        mDialog=new ProgressDialog(this);

        log_email=findViewById(R.id.login_email);
        log_password=findViewById(R.id.login_pass);

        login_button=findViewById(R.id.login_button);
        signUp=findViewById(R.id.Register_link);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail=log_email.getText().toString().trim();
                String mPass=log_password.getText().toString().trim();

                if (TextUtils.isEmpty(mEmail)){
                    log_email.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(mPass)){
                    log_password.setError("Required Field..");
                    return;
                }

                mDialog.setMessage("Processing..");
                mDialog.show();

                mAuth.signInWithEmailAndPassword(mEmail,mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);

                            mDialog.dismiss();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();

                        }
                    }
                });
            }
        });
            signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Register.class));
                }
            });


    }
}