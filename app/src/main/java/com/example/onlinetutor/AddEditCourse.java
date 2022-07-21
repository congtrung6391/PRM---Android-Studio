package com.example.onlinetutor;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinetutor.dao.CourseDAO;
import com.example.onlinetutor.objects.Course;

public class AddEditCourse extends AppCompatActivity {
    private boolean isNew = false;
    private String classType = "";
    private TextView title;
    private EditText idText;
    private EditText nameText;
    private EditText desText;
    private EditText typeText;
    private Button saveButton;
    CourseDAO courseDao;

    private Intent listIntent;

    private void onSetupController() {
        title = findViewById(R.id.add_edit_course_title);
        idText = findViewById(R.id.id_text);
        nameText = findViewById(R.id.name_text);
        desText = findViewById(R.id.des_text);
        typeText = findViewById(R.id.type_text);
        saveButton = findViewById(R.id.save_button);
    }

    private void onSetupIntent() {
        listIntent = new Intent(AddEditCourse.this, ListActivity.class);
    }

    private void onSetupListener() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onSave()) {
                    listIntent.putExtra("class_type", typeText.getText().toString());
                    startActivity(listIntent);
                } else {
                    Toast.makeText(AddEditCourse.this, "Create/Update course failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void onHandleIntent(Intent intent) {
        classType = intent.getStringExtra("class_type");
        isNew = intent.getStringExtra("is_new").equals("new");
        typeText.setText(classType);
        if (isNew) {
            title.setText("Add a new course");
        } else {
            title.setText("Edit course");
            idText.setText(intent.getStringExtra("id"));
            nameText.setText(intent.getStringExtra("name"));
            desText.setText(intent.getStringExtra("des"));
            typeText.setText(intent.getStringExtra("type"));
        }
    }

    private boolean onSave() {
        int id = Integer.parseInt(idText.getText().toString());
        String name = nameText.getText().toString();
        String des = desText.getText().toString();
        String type = typeText.getText().toString();
        Course course = new Course(id, name, des, type);
        if (isNew) {
            return courseDao.add(course);
        }
        return courseDao.update(course);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_course);

        onSetupController();
        onSetupIntent();
        onSetupListener();
        onHandleIntent(getIntent());
        courseDao = new CourseDAO(AddEditCourse.this);
    }
}