package com.example.onlinetutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private ArrayList<Course> mCourses;
    private RecyclerView mRecyclerCourse;
    private CourseAdapter mCourseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        String type = intent.getStringExtra("class_type");

        mRecyclerCourse = findViewById(R.id.recycler_list);
        mCourses = new ArrayList<Course>();
        createHeroList(type);
        mCourseAdapter = new CourseAdapter(this, mCourses);
        mRecyclerCourse.setAdapter(mCourseAdapter);
        mRecyclerCourse.setLayoutManager(new LinearLayoutManager(this));
    }

    private void createHeroList(String type) {
        if (type.equals("math")) {
            mCourses.add(new Course("Math level 1", "Basic math"));
            mCourses.add(new Course("Math level 2", "Basic math"));
            mCourses.add(new Course("Math level 3", "Basic math"));
            mCourses.add(new Course("Math level 4", "Basic math"));
            mCourses.add(new Course("Math level 5", "Basic math"));
            mCourses.add(new Course("Math level 6", "Basic math"));
            mCourses.add(new Course("Math level 7", "Basic math"));
            mCourses.add(new Course("Math level 8", "Basic math"));
            mCourses.add(new Course("Math level 9", "Basic math"));
            mCourses.add(new Course("Math level 10", "Basic math"));
            mCourses.add(new Course("Math level 11", "Basic math"));
            mCourses.add(new Course("Math level 12", "Basic math"));
            mCourses.add(new Course("Math level 13", "Basic math"));
        } else if (type.equals("english")) {
            mCourses.add(new Course("English level 1", "Basic english"));
            mCourses.add(new Course("English level 2", "Basic english"));
            mCourses.add(new Course("English level 3", "Basic english"));
            mCourses.add(new Course("English level 4", "Basic english"));
            mCourses.add(new Course("English level 5", "Basic english"));
            mCourses.add(new Course("English level 6", "Basic english"));
            mCourses.add(new Course("English level 7", "Basic english"));
            mCourses.add(new Course("English level 8", "Basic english"));
            mCourses.add(new Course("English level 9", "Basic english"));
            mCourses.add(new Course("English level 10", "Basic english"));
            mCourses.add(new Course("English level 11", "Basic english"));
            mCourses.add(new Course("English level 12", "Basic english"));
            mCourses.add(new Course("English level 13", "Basic english"));
            mCourses.add(new Course("English level 14", "Basic english"));
            mCourses.add(new Course("English level 15", "Basic english"));
        } else if (type.equals("france")) {
            mCourses.add(new Course("France level 1", "France math"));
            mCourses.add(new Course("France level 2", "France math"));
            mCourses.add(new Course("France level 3", "France math"));
            mCourses.add(new Course("France level 4", "France math"));
            mCourses.add(new Course("France level 5", "France math"));
            mCourses.add(new Course("France level 6", "France math"));
            mCourses.add(new Course("France level 7", "France math"));
            mCourses.add(new Course("France level 8", "France math"));
            mCourses.add(new Course("France level 9", "France math"));
            mCourses.add(new Course("France level 10", "France math"));
            mCourses.add(new Course("France level 11", "France math"));
            mCourses.add(new Course("France level 12", "France math"));
            mCourses.add(new Course("France level 13", "France math"));
            mCourses.add(new Course("France level 14", "France math"));
            mCourses.add(new Course("France level 15", "France math"));
            mCourses.add(new Course("France level 16", "France math"));
            mCourses.add(new Course("France level 17", "France math"));
            mCourses.add(new Course("France level 18", "France math"));
            mCourses.add(new Course("France level 19", "France math"));
            mCourses.add(new Course("France level 20", "France math"));
            mCourses.add(new Course("France level 21", "France math"));
        } else if (type.equals("physic")) {
            mCourses.add(new Course("Physic level 1", "Physic math"));
            mCourses.add(new Course("Physic level 2", "Physic math"));
            mCourses.add(new Course("Physic level 3", "Physic math"));
            mCourses.add(new Course("Physic level 4", "Physic math"));
            mCourses.add(new Course("Physic level 5", "Physic math"));
            mCourses.add(new Course("Physic level 6", "Physic math"));
            mCourses.add(new Course("Physic level 7", "Physic math"));
            mCourses.add(new Course("Physic level 8", "Physic math"));
            mCourses.add(new Course("Physic level 9", "Physic math"));
            mCourses.add(new Course("Physic level 10", "Physic math"));
        }
    }
}