package com.example.studentattendancetracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ParentLogin extends AppCompatActivity {

    Button btn2,dashbtn;
    TextView forget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);


        TextView txt1 = findViewById(R.id.flogin);
        txt1.setMovementMethod(LinkMovementMethod.getInstance());

        dashbtn = findViewById(R.id.log);

        dashbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ParentLogin.this,TestDashboard.class);
                startActivity(intent);

            }
        });

        btn2 = findViewById(R.id.register);
        forget = findViewById(R.id.forgot1);

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(ParentLogin.this,ForgotPassword.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ParentLogin.this,ParentRegistration.class);
                startActivity(intent);

            }
        });

    }
}
