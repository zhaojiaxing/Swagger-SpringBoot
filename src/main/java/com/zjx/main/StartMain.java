package com.zjx.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zjx on 2017/7/5.
 */
@ComponentScan("com.*")
@SpringBootApplication
public class StartMain {
    public static void main(String[] args) {
        SpringApplication.run(StartMain.class, args);
    }

    @Configuration
    static class WebMvcConfigurer extends WebMvcConfigurerAdapter {
        WebMvcConfigurer() {
        }

        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new HandlerInterceptorAdapter() {
                public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + request.getServletPath();
                    if(url.contains("/error")) {
                        response.sendRedirect("/swagger-ui.html");
                    }
                    return true;
                }
            }).addPathPatterns("/**");
        }
    }
}
