package com.example.ssm.core;

public class FrameController {
    //返回请求的页面框架，进行页面渲染
    public String getFrame(String frame) {
        switch (frame) {
            case "login":
                return frame;
            case "index":
                return frame;
            default:
                return "html:frames/" + frame;
        }
    }
}
