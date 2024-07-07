package com.example.my_quiz_app;

import android.util.ArrayMap;

import androidx.annotation.NonNull;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.WriteBatch;

import java.util.Map;

public class DbQuery {
    public static FirebaseFirestore g_storage;

    public static <Object, Exception, String, Map> void createUserData(String email, String name, MyCompleteListener completeListener){
        Map userData=new Map();
        userData.put("Email_id",email);
        userData.put("Name",name);
        userData.put("Total_Score",0);


        DocumentReference userDoc=g_storage.collection("USERS").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
        WriteBatch batch=g_storage.batch();
        batch.set(userDoc,userData);

        DocumentReference countDoc = g_storage.collection("USERS").document("TOTAL_USERS");
        batch.update(countDoc,"COUNT", FieldValue.increment(1));

        batch.commit()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        completeListener.onSuccess();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull java.lang.Exception e) {
                        
                    }

                });
    }
}

