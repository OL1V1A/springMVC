package com.lwj.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ConfigOfAop {

    @Bean
    public Div div() {
        return new Div();
    }

    @Bean
    public LogAop logAop() {
        return new LogAop();
    }
}
