package com.example.trade.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 马文迪
 * @Date: 2021/02/01/10:44
 * @Description:
 * @Version:
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");
        log.debug("进入拦截器");
        Cookie[] cookies = request.getCookies();
        if(cookies!=null && cookies.length>0){
            for(Cookie cookie:cookies) {
                log.debug("cookie===for遍历"+cookie.getName());
                if (StringUtils.equalsIgnoreCase(cookie.getName(), "isLogin")) {
                    log.debug("有cookie ---isLogin，并且cookie还没过期...");
                    //遍历cookie如果找到登录状态则返回true继续执行原来请求url到controller中的方法
                    return true;
                }
            }
        }
        log.debug("没有cookie-----cookie时间可能到期，重定向到登录页面后请重新登录。。。");
        System.out.println("没有cookie-----cookie时间可能到期，重定向到登录页面后请重新登录。。。");
        //这里必须得能定位到html文件才行，放在static文件夹下可以直接访问到。或者直接"/",这意味着请求index.html
        //response.sendRedirect("/html/login.html");
        response.sendRedirect("/");

        //String path = request.getContextPath();
        //String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
        //System.out.println(basePath);
        //System.out.println(request.getRequestURI().toString());
        //response.sendRedirect(basePath+"index.html");

        //response.sendRedirect("login.html");
        //返回false，不执行原来controller的方法
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
