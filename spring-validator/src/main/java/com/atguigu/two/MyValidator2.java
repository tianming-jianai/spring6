package com.atguigu.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.two
 * @author: 张世罡
 * @CreateTime: 2023/3/31 21:32
 * @Description:
 */
@Service
public class MyValidator2 {

    @Autowired
    private Validator validator;

    public boolean validatorByUserTwo(User user) {
        BindException bindException = new BindException(user, user.getName());
        validator.validate(user, bindException);
        List<ObjectError> allErrors = bindException.getAllErrors();
        // 输出所有错误信息
        System.out.println(allErrors);
        return bindException.hasErrors();
    }
}
