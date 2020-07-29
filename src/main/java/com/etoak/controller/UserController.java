package com.etoak.controller;


import com.etoak.dto.UserDto;
import com.etoak.entity.User;
import com.etoak.param.UserQueryParam;
import com.etoak.service.UserService;
import com.etoak.utils.PageableRestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 14:26 2020/7/13
 */
@RestController
@RequestMapping("/login/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public User addUser(User user){
        User result = userService.addUser(user);
        return result;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public String delUser(@PathVariable("id") Integer id){
        String result = userService.deleteUserById(id);
        return result;
    }


    @PutMapping("/edit")
    public void updateUser(User user){
        userService.updateUser(user);
    }
    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("query/{id}")
    public User queryUserById(@PathVariable("id")Integer id){
        User user = userService.queryUserById(id);
        return user;
    }


    /**
     * 分页查询用户(姓名模糊查询)
     */

    @GetMapping("list")

    public PageableRestResult<List<UserDto>> queryByPage(UserQueryParam param){
        Page<UserDto> page = userService.queryByPage(param);
        return PageableRestResult.success(page.getContent(),page.getTotalPages(),page.getTotalElements());
    }



}
