package com.example.onlinetutor;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinetutor.dao.CourseDAO;
import com.example.onlinetutor.objects.Course;

public class DetailActivity extends AppCompatActivity {
    private static final int MY_PERMISSION_REQUEST_CODE_CALL_PHONE = 555;
    private static final String LOG_TAG = "DetailActivity";

    private TextView courseIdTextView;
    private TextView courseNameTextView;
    private TextView courseDescriptionTextView;
    private Button callButton;
    private Intent callIntent;
    private Intent openMapIntent;
    private Button openMapButton;

    private String phoneNumber;

    CourseDAO courseDao;

    void onSetupComponent() {
        courseNameTextView = findViewById(R.id.detail_course_name);
        courseIdTextView = findViewById(R.id.detail_course_id);
        courseDescriptionTextView = findViewById(R.id.detail_course_description);
        callButton = findViewById(R.id.call_tutor_button);
        openMapButton = findViewById(R.id.open_map_button);
    }

    void onSetupData() {
        Intent intent = getIntent();
        int courseId = Integer.parseInt(intent.getStringExtra("course_id"));
        Course course = courseDao.get(courseId);
        phoneNumber = "+84921221833";
        callButton.setText("Call tutor: " + phoneNumber);
        courseIdTextView.setText("ID: " + courseId + "");
        courseNameTextView.setText("Name: " + course.getCourseName());
        courseDescriptionTextView.setText("Description: " + course.getCourseDescription());
    }

    void onSetupIntent() {
        callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        openMapIntent = new Intent(DetailActivity.this, MapsActivity.class);
    }

    @SuppressLint("MissingPermission")
    private void callNow() {
        try {
            this.startActivity(callIntent);
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),"Your call failed... " + ex.getMessage(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

    private void openMap() {
        startActivity(openMapIntent);
    }

    void askPermissionAndCall() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) { // 23

            // Check if we have Call permission
            int sendSmsPermisson = ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.CALL_PHONE);

            if (sendSmsPermisson != PackageManager.PERMISSION_GRANTED) {
                // If don't have permission so prompt the user.
                this.requestPermissions(
                        new String[]{Manifest.permission.CALL_PHONE},
                        MY_PERMISSION_REQUEST_CODE_CALL_PHONE
                );
                return;
            }
        }
        this.callNow();
    }

    void onSetupListener() {
        this.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPermissionAndCall();
            }
        });

        this.openMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openMap(); }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        courseDao = new CourseDAO(DetailActivity.this);

        onSetupComponent();
        onSetupIntent();
        onSetupListener();
        onSetupData();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSION_REQUEST_CODE_CALL_PHONE: {

                // Note: If request is cancelled, the result arrays are empty.
                // Permissions granted (CALL_PHONE).
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.i( LOG_TAG,"Permission granted!");
                    Toast.makeText(this, "Permission granted!", Toast.LENGTH_LONG).show();

                    this.callNow();
                }
                // Cancelled or denied.
                else {
                    Log.i( LOG_TAG,"Permission denied!");
                    Toast.makeText(this, "Permission denied!", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }

    // When results returned
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MY_PERMISSION_REQUEST_CODE_CALL_PHONE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Action OK", Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Action Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();
            }
        }
    }
}