package com.example.trade.mapper;

import com.example.trade.entity.Mark;
import com.example.trade.entity.Teacher;
import com.example.trade.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {
     List<Teacher> findAll();

     Teacher selectByTeacher(Integer id);

     List<Mark> getClassMark(Integer id);

    public void add(Teacher teacher);

    List<User> findByIdAndPass(@Param("name") String name, @Param("password")String password);

}
