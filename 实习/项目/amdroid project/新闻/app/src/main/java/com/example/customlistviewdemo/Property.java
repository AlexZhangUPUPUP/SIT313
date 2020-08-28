package com.example.customlistviewdemo;
// A class to keep the information about the property
public class Property {
private int id, image;
private String describe;
    //Constructor
    public Property( int image, String describe ) {

        this.image = image;
        this.describe = describe;
    }

    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }

    public String getAddress() {
        return describe;
    }
    public void setAddress(String describe) {
        this.describe = describe;
    }



}
