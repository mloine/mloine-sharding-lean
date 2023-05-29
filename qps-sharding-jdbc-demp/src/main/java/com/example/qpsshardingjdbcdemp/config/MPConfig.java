package com.example.qpsshardingjdbcdemp.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MPConfig {

    @Bean
    public MybatisPlusInterceptor getInterceptor(){
        //创建MP拦截器
        MybatisPlusInterceptor MPInterceptor = new MybatisPlusInterceptor();
        //添加分页拦截器
        MPInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        //将设置好的拦截器返回
        return MPInterceptor;
    }

}