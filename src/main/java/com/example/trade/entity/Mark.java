package com.example.trade.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
public class Mark {


    private int id;

    private int studentId;

    private String course;

    private int teacherId;

    private int score;


}
