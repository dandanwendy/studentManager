package com.example.trade.dto;

import com.example.trade.entity.Mark;
import lombok.Data;

import java.util.List;

@Data
public class StudentLearning {
    private int id;
    /**姓名 */
    private String name;
    /**性别 */
    private String sex;
    /** 年龄*/
    private int age;
    /**家庭住址 */
    private String home;
    /**学历 */
    private String education;
    /** 导师*/
    private String tutor;
    /** 专业*/
    private String major;
    /** 学院*/
    private String school;

    private List<Mark> marks;
}
