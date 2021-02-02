package com.example.trade.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.trade.dto.StaticStudent;
import com.example.trade.dto.StudentLearning;
import com.example.trade.entity.Student;

import java.util.List;

public interface IStudentService {
     //List<Student> findAll();

     List<Student> findAll( );

     void add(Student stu);

     StudentLearning studentInfo(Integer id);

     Integer selectByCourse(Integer id,String course);

     StaticStudent getAverage(Integer id);
}
