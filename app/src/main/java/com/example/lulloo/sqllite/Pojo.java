package com.example.lulloo.sqllite;

public class Pojo {
    String id,name,marks;
    private byte[] image;

    public Pojo(String id, String name, String marks, byte[] image) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
