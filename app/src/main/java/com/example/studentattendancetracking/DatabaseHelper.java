package com.example.studentattendancetracking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, "Registration.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table admin(username text,email text,staffID text primary key,password text,confirmPassword text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("Drop table if exists admin");

    }


    public boolean insert(String un,String email,String sid,String pass,String cpass){


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",un);
        contentValues.put("email",email);
        contentValues.put("staffID",sid);
        contentValues.put("password",pass);
        contentValues.put("confirmPassword",cpass);

        long ins = db.insert("admin",null,contentValues);
        if(ins == -1)

             return false;

             else
                  return true;

    }

    public boolean checkID(String staffID){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from admin where staffID=?",new String[]{staffID});

        if(cursor.getCount()>0){
            return false;
        }
          else
              return true;

    }

    public boolean checkPassword(String pass){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from admin where password=?",new String[]{pass});

        if (cursor.getCount()>0) {
            return false;

        }
        else

            return true;

    }




    public boolean retrieveData(String email,String sid,String passw){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * From admin where email=? and staffID=? and password=?",new String[]{email,sid,passw});

       if(cursor.getCount()>0)
           return false;

       else
           return true;

    }




}
