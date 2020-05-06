package com.funcode.example.chapter6.request;

import com.funcode.example.chapter6.groups.Update;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Email;

/**
 * @author 代码那些事儿
 */
public class UserReq {

    /***
     * 只有在Update分组时才会校验该属性
     */
//    @NotNull(message = "更新操作id不能为空", groups = Update.class)
//    private Long id;
//
//    @NotBlank(message = "姓名不能为空")
//    private String name;
//
//    @Min(value = 18, message ="年龄须大于18")
//    @NotNull(message = "年龄不能为空")
//    private Integer age;

    @Email(message = "非法的邮箱格式")
    private String email;

//    @Length(min=11,max=11, message = "手机号长度必须为11位")
//    @Pattern(regexp = "^1([34578])\\d{9}$", message = "非法的手机号")
//    @NotBlank(message = "手机号不能为空")
//    private String phone;


//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
}
