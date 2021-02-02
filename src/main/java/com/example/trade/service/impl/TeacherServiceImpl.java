package com.example.trade.service.impl;

import com.example.trade.dto.StaticStudent;
import com.example.trade.dto.TeacherClass;
import com.example.trade.entity.Mark;
import com.example.trade.entity.Student;
import com.example.trade.entity.Teacher;
import com.example.trade.entity.User;
import com.example.trade.mapper.MarkMapper;
import com.example.trade.mapper.StudentMapper;
import com.example.trade.mapper.TeacherMapper;
import com.example.trade.service.TeacherService;
import com.example.trade.utils.StaticStudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private MarkMapper markMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.findAll();
    }

   /* @Override
    public  List<Mark> selectByTeacher(Integer id){
        return teacherMapper.selectByTeacher(id);
    }*/

    /**
     * 该函数传入一个教师id，可以查找该教师班级李每位学生的姓名及科目分数
     * 老师与学生是一对多关系，我们封装多个学生直接用staticStudent对象，因为它既含有学生姓名及分数。如果需要更多的学生信息需要重建一个中间学生类，
     * 充当老师类中的List<Student>
     * @param id
     * @return
     */
    @Override
    public TeacherClass getClass(Integer id){
        TeacherClass teacherClass = new TeacherClass();
        Teacher teacher = teacherMapper.selectByTeacher(id);
        teacherClass.setId(id);
        teacherClass.setCourse(teacher.getCourse());
        teacherClass.setTeacherName(teacher.getTeacherName());

        List<Mark> marks = teacherMapper.getClassMark(id);

        List<StaticStudent> studentList = new LinkedList<>();

        String course = teacher.getCourse();
        for(int i=0;i<marks.size();i++){
            int studnetId = marks.get(i).getStudentId();
            Student student = studentMapper.selectById(studnetId);
            StaticStudent staticStudent = StaticStudentUtil.buildStaticStudent();
            staticStudent.setId(student.getId());
            staticStudent.setName(student.getName());

            //本来想根据老师教授的课，给staticStudent中的对应科目赋值，但是我不会在前端根据科目，选择展示对应的分数
            //于是只能把该老师教授的分数暂时保存在average属性中
           if(course.equals("语文")){
               staticStudent.setAverage(marks.get(i).getScore());
           }else if(course.equals("数学")){
               staticStudent.setAverage(marks.get(i).getScore());
           }else if(course.equals("英语")){
               staticStudent.setAverage(marks.get(i).getScore());
           }
           studentList.add(staticStudent);
        }
        teacherClass.setList(studentList);
        return teacherClass;
    }

    @Override
    public void add(Teacher teacher) {
        teacherMapper.add(teacher);
    }

    @Override
    public void insertMark(Mark mark){
        markMapper.insert(mark);
    }

    @Override
    public List<User> findByIdAndPass(String name, String password) {
        return teacherMapper.findByIdAndPass(name, password);
    }
}
