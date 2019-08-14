package com.example.studentattendancetracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TestDashboard extends AppCompatActivity {

    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dashboard);


        img = findViewById(R.id.profileimg);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(TestDashboard.this,profile.class);
                startActivity(intent);
            }
        });


    }
}
