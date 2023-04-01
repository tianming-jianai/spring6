package com.atguigu.three;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.three
 * @author: 张世罡
 * @CreateTime: 2023/4/1 10:24
 * @Description:
 */
@Service
@Validated
public class MyService {

    public String testMethod(@NotNull @Valid User user) {
        return user.toString();
    }
}
