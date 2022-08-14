package com.spring.xml;

public class Head {
    private String eye;
    //头发

    private String hair;

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public Head(String eye , String hair){
        this.eye = eye;
        this.hair = hair;

    }

    public Head() {
    }
}
