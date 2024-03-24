package com.kitri.miniproject_todolist.config;

import com.kitri.miniproject_todolist.interceptor.CheckUserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CheckUserInterceptor())
                .addPathPatterns("/api/todos");
    }
}
