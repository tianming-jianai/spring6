package com.atguigu.three;

import com.atguigu.four.CanNotBlank;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.three
 * @author: 张世罡
 * @CreateTime: 2023/4/1 10:20
 * @Description:
 */
public class User {

    @NotNull
    private String name;

    @Min(0)
    @Max(150)
    private int age;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @CanNotBlank
    private String message;

    public User(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public User(String name, int age, String phone, String message) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
