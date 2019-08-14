package com.example.studentattendancetracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button bn1,loginbtn;
    TextView bn2;
    EditText e1,e2,e3;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        e1 = findViewById(R.id.email);
        e2 = findViewById(R.id.staff);
        e3 = findViewById(R.id.password);


        TextView txt = findViewById(R.id.txt4);
        txt.setMovementMethod(LinkMovementMethod.getInstance());

        loginbtn = findViewById(R.id.loginButton);
        bn1 = findViewById(R.id.signupButton);
        bn2 = findViewById(R.id.forgot);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = e1.getText().toString();
                String staffID = e2.getText().toString();
                String password = e3.getText().toString();

                Boolean data = db.retrieveData(email,staffID,password);

                if(data == false) {

                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();


                  Intent intent = new Intent(Login.this, TestDashboard.class);
                  startActivity(intent);
                }

                else

                    Toast.makeText(getApplicationContext(),"Enter Valid credentials",Toast.LENGTH_SHORT).show();


              //  Intent intent = new Intent(Login.this,TestDashboard.class);
             //   startActivity(intent);

            }
        });

        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login.this,ForgotPassword.class);
                startActivity(intent);
            }
        });

        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login.this, AdminRegistrarion.class);
                startActivity(intent);
            }
        });



    }
}
