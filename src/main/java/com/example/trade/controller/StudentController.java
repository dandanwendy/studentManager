package com.example.trade.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.trade.dto.StaticStudent;
import com.example.trade.dto.StudentLearning;
import com.example.trade.entity.Student;
import com.example.trade.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    /**
     *
     */
    @Autowired
    private IStudentService studentService;

    public StudentController() throws ClassNotFoundException {
    }

   /* @GetMapping("/list1")
    @ResponseBody*//*不加ResponseBody注解无法响应到前端页面*//*
    public Student quick(){
        List<Student> students = studentService.findAll();
        return students.get(0);
    }*/

    //该方法主要是为了验证mabatis的一对多封装
    @GetMapping("/studentInfo")
    @ResponseBody//不加ResponseBody注解无法响应到前端页面
    public StudentLearning studentInfo(@RequestParam(value="id",required=true,defaultValue="2")Integer id){
        return studentService.studentInfo(id);
    }


    @RequestMapping("/list")
    public String findAll( Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students);
        return "list";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Student student) {
        studentService.add(student);
        return "redirect:/student/list";
        //return "/list";
    }

    @GetMapping("/checkMark")
    public String checkMark(Model model){
        return "checkMark";
    }

    //该方法计算学生的三科平均分
    @GetMapping("/average")
    public String getAverage(@RequestParam(value="id",required=true,defaultValue="1")Integer id,Model model){
        StaticStudent staticStudent = studentService.getAverage(id);
        model.addAttribute("staticStudent", staticStudent);
        return "studentMark";
    }

   //该方法验证PathVariable的注解的用法
    @GetMapping("/average3/{id}")
    public String getAverage3(@PathVariable("id")Integer id,Model model ){
        StaticStudent staticStudent = studentService.getAverage(id);
        model.addAttribute("staticStudent", staticStudent);
        return "studentMark";
    }

    //ModelAndView的用法，可以设置返回的页面
    @GetMapping("/average2")
    public ModelAndView getAverage2(@RequestParam(value="id",required=true,defaultValue="1")Integer id){
        ModelAndView mv = new ModelAndView();
        StaticStudent staticStudent = studentService.getAverage(id);
        mv.addObject("staticStudent", staticStudent);
        mv.setViewName("studentMark");
        return mv;
    }

    //这个方法好像没有成功
    @RequestMapping("/show18")
    public ModelAndView test18(@RequestParam(value="name",required=true,defaultValue="hello")String name){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg", "接收普通请求参数：" + name);
        return mv;
    }

    /*
    @GetMapping("/register1")
    public String loginController(Model model){
        model.addAttribute("student", new Student());
        return "register";
    }
    @PostMapping("/register1")
    public String greetingSubmit(@ModelAttribute Student student) {
        return "result";
    }*/
}
