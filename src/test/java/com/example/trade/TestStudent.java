package com.example.trade;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.trade.entity.Student;
import com.example.trade.mapper.StudentMapper;
import com.example.trade.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStudent {

    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void testStudent(){
        System.out.println(iStudentService.selectByCourse(13,"语文"));
    }
    @Test
    public void print(){
        IPage<Student> iPage = studentMapper.selectPage(new Page<>(1, 3), null);
        List<Student> list = iPage.getRecords();
        for(Student user : list){
            System.out.println(user);
          }
    }
}
