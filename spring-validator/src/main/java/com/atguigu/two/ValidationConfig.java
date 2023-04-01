package com.atguigu.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.two
 * @author: 张世罡
 * @CreateTime: 2023/3/31 21:24
 * @Description:
 */
@Configuration
@ComponentScan("com.atguigu.two")
public class ValidationConfig {

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
}
