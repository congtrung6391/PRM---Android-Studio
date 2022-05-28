package com.example.onlinetutor;

public class Course {
    private String courseName;
    private String courseDescription;

    public Course(String name, String des) {
        this.courseName = name;
        this.courseDescription = des;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getCourseName() {
        return courseName;
    }

    void setCourseName(String name) {
        this.courseName = name;
    }

    void setCourseDescription(String des) {
        this.courseDescription = des;
    }
}
