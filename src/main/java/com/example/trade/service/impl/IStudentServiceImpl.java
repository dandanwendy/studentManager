package com.example.trade.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.trade.dto.StaticStudent;
import com.example.trade.dto.StudentLearning;
import com.example.trade.entity.Student;
import com.example.trade.mapper.StudentMapper;
import com.example.trade.service.IStudentService;
import com.example.trade.utils.StaticStudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    /*@Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }*/

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public void add(Student stu){
        studentMapper.add(stu);
    }

    @Override
    public StaticStudent getAverage(Integer id){
        StaticStudent staticStudent = StaticStudentUtil.buildStaticStudent();
        staticStudent.setId(id);
        staticStudent.setName(studentMapper.selectById(id).getName());

        Integer chinese = studentMapper.selectByCourse(id,"语文");
        Integer math = studentMapper.selectByCourse(id,"数学");
        Integer english = studentMapper.selectByCourse(id,"英语");
        staticStudent.setChinese(chinese);
        staticStudent.setMath(math);
        staticStudent.setEnglish(english);
        staticStudent.setAverage((chinese+math+english)/3.0);
        return staticStudent;
    }

    @Override
    public StudentLearning studentInfo(Integer id){
        return studentMapper.studentInfo(id);
    }

    @Override
    public Integer selectByCourse(Integer id,String course){
        return studentMapper.selectByCourse(id,course);
    }
}
