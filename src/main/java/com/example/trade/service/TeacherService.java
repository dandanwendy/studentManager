package com.example.trade.service;

import com.example.trade.dto.TeacherClass;
import com.example.trade.entity.Mark;
import com.example.trade.entity.Teacher;
import com.example.trade.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

  //  List<Mark> selectByTeacher(Integer id);

    void add(Teacher teacher);

    void insertMark(Mark mark);

    TeacherClass getClass(Integer id);

    List<User> findByIdAndPass(String name, String password);

}
