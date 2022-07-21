package com.example.onlinetutor.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.onlinetutor.objects.Course;
import com.example.onlinetutor.objects.User;
import com.example.onlinetutor.utils.DBHelper;

import java.util.ArrayList;

public class CourseDAO {
    DBHelper data;
    // ham khoi tao
    public CourseDAO(Context context) {
        data = new DBHelper(context);
    }

    public boolean isExist(int courseID){
        SQLiteDatabase db = data.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from COURSE where id=?",new String[]{
                courseID + "",
        });
        if(cs.getCount() <=0){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean update(Course course){
        SQLiteDatabase db = data.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", course.getCourseName());
        values.put("description", course.getCourseDescription());
        values.put("type", course.getCourseType());
        int row = db.update("COURSE",values,"id=?",new String[]{course.getId() + ""});
        return row>0;
    }

    public ArrayList<Course> readAll(String typeQuery, String nameQuery){
        ArrayList<Course> listCourse = new ArrayList<>();

        SQLiteDatabase db = data.getReadableDatabase();

        String nameFilter;
        if (nameQuery == null) {
            nameFilter = "%%";
        } else {
            nameFilter = "%" + nameQuery + "%";
        }
        Log.d("DAO", "readAll: " + typeQuery);
        Log.d("DAO", "readAll: " + nameFilter);
        Cursor cs = db.rawQuery("select * from COURSE where name like ?", new String[]{nameFilter});
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            int id = cs.getInt(0);
            String name = cs.getString(1);
            String des = cs.getString(2);
            String type = cs.getString(3);
            listCourse.add(new Course(id, name, des, type));
            cs.moveToNext();
        }
        cs.close();
        return listCourse;
    }

    //add
    public boolean add(Course course){
        SQLiteDatabase db = data.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", course.getId());
        values.put("name", course.getCourseName());
        values.put("description", course.getCourseDescription());
        values.put("type", course.getCourseType());
        long row = db.insert("COURSE",null, values);
        return row>0;
    }

    //delete
    public boolean delete(int courseId){
        SQLiteDatabase db = data.getReadableDatabase();
        ContentValues values = new ContentValues();

        long row = db.delete("COURSE","id = ?",
                new String[]{courseId + ""});
        return row>0;
    }

    public Course get(int courseId){
        Course course = null;

        SQLiteDatabase db = data.getReadableDatabase();

        Cursor cs = db.rawQuery("select * from COURSE where id=?",new String[]{
                courseId + "",
        });
        cs.moveToFirst();
        if (!cs.isAfterLast()) {
            int id = cs.getInt(0);
            String name = cs.getString(1);
            String des = cs.getString(2);
            String type = cs.getString(3);
            course = new Course(id, name, des, type);
            cs.moveToNext();
        }
        cs.close();
        return course;
    }
}
