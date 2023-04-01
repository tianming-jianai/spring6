package com.atguigu.three;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.three
 * @author: 张世罡
 * @CreateTime: 2023/4/1 10:19
 * @Description:
 */
@Configuration
@ComponentScan("com.atguigu.three")
public class ValidationConfig {

    @Bean
    public MethodValidationPostProcessor validationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
}
