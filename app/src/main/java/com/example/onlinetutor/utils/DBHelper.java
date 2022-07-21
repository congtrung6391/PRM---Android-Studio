package com.example.onlinetutor.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "lab10", null, 1);
    }

    private String createUserTable = "CREATE TABLE USER(" +
            "username Text primary  key not null," +
            "fullname Text," +
            "email Text," +
            "password Text)";

    private String createCourseTable = "CREATE TABLE COURSE(" +
            "id Number primary key not null," +
            "name Text not null," +
            "description," +
            "type)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.createUserTable);
        db.execSQL(this.createCourseTable);
        db.execSQL("INSERT INTO USER values('user01', 'Demo User 01', 'user01@gmail.com', 'abc123@')");
        db.execSQL("INSERT INTO USER values('user02', 'Demo User 02', 'user02@gmail.com', 'abc123@')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USER");
        db.execSQL("DROP TABLE IF EXISTS COURSE");
        onCreate(db);

    }
}
