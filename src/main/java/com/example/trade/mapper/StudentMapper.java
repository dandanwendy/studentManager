package com.example.trade.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.trade.dto.StudentLearning;
import com.example.trade.entity.Student;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    //@Select("select * from account")
   // public List<Student> findAll();
    public List<Student> findAll();

    public void add(Student stu);

    public Student selectById(Integer id);

    public StudentLearning studentInfo(Integer id);

    //多个参数，这里需要使用注解@Param绑定参数
    public Integer selectByCourse(@Param("id") Integer id, @Param("course")String course);
}
