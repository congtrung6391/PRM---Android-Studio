package com.example.onlinetutor.objects;

import java.io.Serializable;

public class Course implements Serializable {
    private String id;
    private String courseName;
    private String courseDescription;
    private String courseType;

    public Course(String id, String name, String des, String type) {
        this.id = id;
        this.courseName = name;
        this.courseDescription = des;
        this.courseType = type;
    }

    public String getId() { return this.id; }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseName(String name) {
        this.courseName = name;
    }

    public void setCourseDescription(String des) {
        this.courseDescription = des;
    }

    public void setCourseType(String type) { this.courseType = type; }
}
