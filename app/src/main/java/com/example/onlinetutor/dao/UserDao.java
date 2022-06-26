package com.example.onlinetutor.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.onlinetutor.objects.User;
import com.example.onlinetutor.utils.DBHelper;

import java.util.ArrayList;


public class UserDao {
    DBHelper data;
    // ham khoi tao
    public UserDao(Context context) {
        data = new DBHelper(context);
    }

    //ham kiem tra user
    public boolean isExist(String username, String password){
        SQLiteDatabase db = data.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from USER where username =? and password=?",new String[]{
                username,
                password
        });
        if(cs.getCount() <=0){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean update(User user){
        SQLiteDatabase db = data.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("password",user.getPassword());
        int row = db.update("USER",values,"username",new String[]{user.getUsername()});
        return row>0;
    }

    public ArrayList<User> readAll(){
        ArrayList<User> listUser = new ArrayList<>();

        SQLiteDatabase db = data.getReadableDatabase();

        Cursor cs = db.rawQuery("select * from USER", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            String username = cs.getString(0);
            String fullname = cs.getString(1);
            String email = cs.getString(2);
            String password = cs.getString(3);
            listUser.add(new User(username,fullname, email, password));
            cs.moveToNext();
        }
        cs.close();
        return listUser;
    }

    //add
    public boolean add(User user){
        SQLiteDatabase db = data.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",user.getUsername());
        values.put("fullname",user.getFullname());
        values.put("email",user.getEmail());
        values.put("password",user.getPassword());
        long row = db.insert("USER",null, values);
        return row>0;
    }

    //delete
    public boolean delete(String username){
        SQLiteDatabase db = data.getReadableDatabase();
        ContentValues values = new ContentValues();

        long row = db.delete("USER","username = ?",
                new String[]{username});
        return row>0;
    }
}
