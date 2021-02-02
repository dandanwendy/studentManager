package com.example.trade.utils;

import com.example.trade.dto.StaticStudent;

public class StaticStudentUtil {
    public static StaticStudent buildStaticStudent() {
        return StaticStudent.builder().chinese(0).math(0).english(0).build();
    }
}
