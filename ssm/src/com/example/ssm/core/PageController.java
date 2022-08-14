package com.example.ssm.core;

import java.text.MessageFormat;

public class PageController {
    public PageController() {
    }

    public String getPages(String pageName) {
        return MessageFormat.format("html:{0}", pageName);
    }
}
