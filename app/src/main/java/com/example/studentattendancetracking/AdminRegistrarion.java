package com.example.studentattendancetracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminRegistrarion extends AppCompatActivity {

    DatabaseHelper db;
    CheckBox ch;
    EditText edit1,edit2,edit3,edit4,edit5;


    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registration);

        db = new DatabaseHelper(this);
        edit1 = findViewById(R.id.Uname);
        edit2 = findViewById(R.id.email);
        edit3 = findViewById(R.id.staffid);
        edit4 = findViewById(R.id.pass1);
        edit5 = findViewById(R.id.passC);
        ch = findViewById(R.id.cbox);

        btn1 = findViewById(R.id.signup);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String s1 = edit1.getText().toString();
                String s2 = edit2.getText().toString();
                String s3 = edit3.getText().toString();
                String s4 = edit4.getText().toString();
                String s5 = edit5.getText().toString();

                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")){

                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }

                else {


                 //   String valid = "a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                   //         "\\@" +
                     //       "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                       //     "(" +
                         //   "\\." +
                           // "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                            //")+";


                   // Matcher matcher = Pattern.compile(valid).matcher(s2);

                  //  if (matcher.matches()) {

                      //  Toast.makeText(getApplicationContext(),"Valid Email ID",Toast.LENGTH_SHORT).show();

                        if (s4.equals(s5)) {

                            Boolean checkID = db.checkID(s3);


                            if (checkID == true) {

                                Boolean checkPass = db.checkPassword(s4);

                                if (checkPass == true) {

                                    Boolean insert = db.insert(s1, s2, s3, s4, s5);

                                    if (insert == true) {

                                        ch.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(AdminRegistrarion.this, TestDashboard.class);
                                                startActivity(intent);
                                            }
                                        });


                                        Toast.makeText(getApplicationContext(), "Agree to terms and conditions", Toast.LENGTH_SHORT).show();

                                        // Intent intent = new Intent(AdminRegistrarion.this, TestDashboard.class);
                                        //startActivity(intent);
                                    }

                                } else
                                    Toast.makeText(getApplicationContext(), "Password already exists", Toast.LENGTH_SHORT).show();

                            } else {

                                Toast.makeText(getApplicationContext(), "Staff ID Already exists", Toast.LENGTH_SHORT).show();
                            }

                        } else

                            Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();

                   // }

                   // else {
                       // Toast.makeText(getApplicationContext(), "Enter Valid Email ID", Toast.LENGTH_SHORT).show();
                   // }

                }

               // Intent intent = new Intent(AdminRegistrarion.this,TestDashboard.class);
               // startActivity(intent);

            }
        });
    }
}
