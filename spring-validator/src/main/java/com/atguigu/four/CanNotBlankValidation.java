package com.atguigu.four;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.four
 * @author: 张世罡
 * @CreateTime: 2023/4/1 10:39
 * @Description:
 */
public class CanNotBlankValidation implements ConstraintValidator<CanNotBlank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        // null时不进行校验
        if (value != null && value.contains(" ")) {
            // 获取默认提示信息
            String message = ctx.getDefaultConstraintMessageTemplate();
            System.out.println("default message：" + message);
            // 禁用默认提示信息
            ctx.disableDefaultConstraintViolation();
            // 设置提示语
            ctx.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();
        }
        return true;
    }
}
