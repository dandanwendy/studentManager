package com.example.trade.dto;

import com.example.trade.entity.Mark;
import com.example.trade.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class TeacherClass {
    private int id;

    private String teacherName;

    private String course;

    private List<StaticStudent> list;
}
