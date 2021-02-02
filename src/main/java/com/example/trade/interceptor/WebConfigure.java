package com.example.trade.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 马文迪
 * @Date: 2021/02/01/10:43
 * @Description:
 * @Version:
 */
@Configuration
public class WebConfigure implements WebMvcConfigurer {



    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //不知道这种为啥不能同时拦截teacher与studnet
       /* registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/teacher/**","/studnet/**")
                .excludePathPatterns("/login","/index.html");*/

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/student/**").addPathPatterns("/teacher/**")
                .excludePathPatterns("/login","/index.html");
    }

}
