package com.example.demo.util;

import static com.example.demo.constants.Const.URL_START;

import jakarta.servlet.http.HttpServletRequest;

public abstract class Utilis {

    public static String applicationUrl(HttpServletRequest request) {
        return URL_START
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath();
    }

}
