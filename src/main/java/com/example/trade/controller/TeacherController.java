package com.example.trade.controller;

import com.example.trade.dto.TeacherClass;
import com.example.trade.entity.Mark;
import com.example.trade.entity.Teacher;
import com.example.trade.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/list")
    public String findAll( Model model) {
        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers",teachers);
        return "teacherList";
    }

    @GetMapping("/checkClass")
    public String checkMark(Model model){
        return "checkClass";
    }

    @GetMapping("/class")
    public String selectByTeacher(@RequestParam(value="id",required=true,defaultValue="1") Integer id,Model model){
        TeacherClass teacherClass= teacherService.getClass(id);
        model.addAttribute("class",teacherClass);
        return "class";
    }

    @GetMapping("/class2")
    @ResponseBody
    public TeacherClass selectByTeacher(@RequestParam(value="id",required=true,defaultValue="1") Integer id){
        return teacherService.getClass(id);
    }

    //这里必须要把teacher对象返回到前端，不然页面不知道teacher是什么类型的对象
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("teacher", new Teacher());
        return "teacherRegister";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Teacher teacher) {
        teacherService.add(teacher);
        return "redirect:/teacher/list";
    }

    @GetMapping("/inputMark")
    public String inputStudentMark(Model model){
        model.addAttribute("mark", new Mark());
        return "insertMark";
    }

    @PostMapping("/insertMark")
    public String insertMark(@ModelAttribute Mark mark){
       teacherService.insertMark(mark);
        return "redirect:/teacher/list";
    }

    @GetMapping("/testmyajax")
    public String testmyajax(){
        return "myajax";
    }

    @GetMapping("/testAjax2")
    @ResponseBody
    public Object testAjax2(){
        return new Integer("10");
    }

}
