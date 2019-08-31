package com.sky.boot.config;

import com.sky.boot.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展原理:
 * BeanPostProcessor:bean后置处理器,bean创建对象初始化前后进行拦截工作
 * BeanFactoryPostProcessor:BeanFactory的后置处理器
 *
 */
@ComponentScan(basePackages = {"com.sky.boot"})
@Configuration
public class ExtConfig {

    @Bean
    public Blue blue(){
        return new Blue();
    }
}
