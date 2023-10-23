package com.example.demo.util;

import java.time.LocalDate;

public abstract class TimeUtilits {
    public static LocalDate getCurrentDateTime() {
        return LocalDate.now();
    }
}