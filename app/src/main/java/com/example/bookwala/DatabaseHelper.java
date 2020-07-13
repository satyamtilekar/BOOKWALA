package com.example.bookwala;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DatabaseHelper {
    static final String key_fname = "fname";
    static final String key_lname = "lname";
    static final String key_user_id = "user_id";
    static final String key_email = "email";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void add_user_details(int user_id , String fname , String lname , String email) {
        Log.d("here", "add_user_details: first");

        Map<String  , Object> map = new HashMap<>();

        map.put(key_user_id , user_id);
        map.put(key_fname , fname);
        map.put(key_lname , lname);
        map.put(key_email , email);

        Log.d("here", "add_user_details: second");

        db.collection("Users").document().set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("in Success", "onSuccess: ");
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("in Failure", "onFailure: ");
            }
        });

    }

}
