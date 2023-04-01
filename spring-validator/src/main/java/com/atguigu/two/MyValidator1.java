package com.atguigu.two;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.two
 * @author: 张世罡
 * @CreateTime: 2023/3/31 21:29
 * @Description:
 */
@Service
public class MyValidator1 {

    @Autowired
    private Validator validator;

    public boolean validatorByUserOne(User user) {
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        return validate.isEmpty();
    }
}
