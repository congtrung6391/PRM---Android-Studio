package com.example.onlinetutor.objects;

import java.io.Serializable;

public class CourseType implements Serializable {
    private String id;
    private String typeName;

    public CourseType(String id, String name) {
        this.id = id;
        this.typeName = name;
    }

    public CourseType(String name) {
        this.id = null;
        this.typeName = name;
    }

    public void setId(String id) { this.id = id; }

    public void setTypeName(String name) { this.typeName = name; }

    public String getId() { return this.id; }

    public String getTypeName() { return this.typeName; }
}
