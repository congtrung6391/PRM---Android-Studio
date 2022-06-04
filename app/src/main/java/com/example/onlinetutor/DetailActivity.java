package com.example.onlinetutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView courseNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        courseNameTextView = findViewById(R.id.detail_course_name);
        Intent intent = getIntent();
        String courseName = intent.getStringExtra("course_name");
        courseNameTextView.setText(courseName);
    }
}