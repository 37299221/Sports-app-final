package com.example.sports_tournament_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//File made for the database. To be used for account details + anything linked to each account.
public class dbhelper extends SQLiteOpenHelper {

    //Creates a database ith nothing in it
    public dbhelper(Context context) {
        super(context, "Userdata.dp", null, 1);
    }

    //Name of the table created, along with columns for name, contact and password.
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(name TEXT primary key, contact TEXT, password TEXT)");
    }

    //Table will not be made if it already exists.
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    //Method for inserting user data to the database. Takes the relevant text from text fields and inputs them into the chosen rows of the made table (name and contact in this case).
    public Boolean insertuserdata(String name, String contact) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        long result = DB.insert("Userdetails", null, contentValues);

        //If all values exists in the table, it will not be added.
        if (result == 1) {
            return false;
        } else {
            return true;
        }

    }

    //Another method for updating user data. Works similarly to the one above.
    public Boolean updateuserdata(String name, String contact, String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {

            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});

            if (result == 1) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }
    }


    //Deletes all data in the table when used.
    public Boolean deletedata(String name) {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {

            long result = DB.delete("Userdetails", "name=?", new String[]{name});

            if (result == 1) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }

    }

    //Should check all data and check it with two values, but I couldn't get it to work
    public Boolean loginuserdata(String name, String contact) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {

            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});

            if (result == 1) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }
    }

//Selects all data and allows it to be used elsewhere.
    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;
    }

}


