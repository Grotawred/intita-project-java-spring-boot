package com.example.demo.util;

import static com.example.demo.constants.URLConstants.URL_START;

import jakarta.servlet.http.HttpServletRequest;

public abstract class URLUtilis {

    private URLUtilis(){}

    public static String applicationUrl(HttpServletRequest request) {
        return URL_START
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath();
    }

}
