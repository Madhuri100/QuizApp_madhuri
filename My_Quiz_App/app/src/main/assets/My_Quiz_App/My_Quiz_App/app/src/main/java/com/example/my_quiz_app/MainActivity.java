package com.example.my_quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    MaterialCardView easycard, difficultcard;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        easycard=findViewById(R.id.easyCard);
        difficultcard=findViewById(R.id.difficultCard);

        easycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BasicQuiz.class));
                finish();
            }
        });
    difficultcard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, DifficultQuiz.class));
            finish();
        }
    });
    }

    @Override
    public void onBackPressed(){
        MaterialAlertDialogBuilder materialAlertDialogBuilder=new MaterialAlertDialogBuilder(MainActivity.this);
        materialAlertDialogBuilder.setTitle("Exam Practice");
        materialAlertDialogBuilder.setMessage("Are you sure want to exit the app?");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        materialAlertDialogBuilder.show();
    }
}