package com.example.trade.controller;

import com.example.trade.entity.User;
import com.example.trade.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 马文迪
 * @Date: 2021/02/01/11:10
 * @Description:
 * @Version:
 */
@Controller
@Slf4j
@RequestMapping(value = "/")
public class LoginController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping(value = "/login")
    public String test(HttpServletRequest request, HttpServletResponse response, @RequestParam("name1")String name, @RequestParam("pass1")String pass) throws Exception{
        try {
           // Map<String, Object> result= null;
            System.out.println("开始登录查询----------------------------");
            List<User> result = teacherService.findByIdAndPass(name,pass);
            if(result==null || result.size()==0){
                log.debug("账号或者密码不正确或者此人账号没有注册");
                throw new Exception("账号或者密码不正确或者此人账号没有注册！");
            }else{
                log.debug("查询满足条数----"+result);
                Cookie cookie = new Cookie("isLogin", "success");
                cookie.setMaxAge(30);
                cookie.setPath("/");
                response.addCookie(cookie);
                request.setAttribute("isLogin", name);
                log.debug("首次登录，查询数据库用户名和密码无误，登录成功，设置cookie成功");
                return "redirect:/teacher/list";
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            return "error1";
        }
    }

    /** 能进到此方法中，cookie一定没有过期。因为拦截器在前面已经判断力。过期，拦截器重定向到登录页面。过期退出登录，清空cookie。*/
    @RequestMapping(value = "exit",method = RequestMethod.POST)
    public String exit(HttpServletRequest request,HttpServletResponse response) throws Exception{
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if("isLogin".equalsIgnoreCase(cookie.getName())){
                log.debug("退出登录时,cookie还没过期，清空cookie");
                cookie.setMaxAge(0);
                cookie.setValue(null);
                cookie.setPath("/");
                response.addCookie(cookie);
                break;
            }
        }
        //重定向到登录页面
        return  "redirect:index.html";
    }
}
