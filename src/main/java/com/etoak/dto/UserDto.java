package com.etoak.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 14:37 2020/7/13
 */

@Data
public class UserDto {
    private Integer id;
    private String userName;
    private String password;
    private Date createTime;
}
