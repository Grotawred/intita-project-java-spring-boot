package com.example.demo.util;

import jakarta.servlet.http.HttpServletRequest;

import static com.example.demo.constants.URLConstants.URL_START;

public abstract class URLUtilis {

    private URLUtilis() {
    }

    public static String applicationUrl(HttpServletRequest request) {
        return URL_START
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath();
    }

}
