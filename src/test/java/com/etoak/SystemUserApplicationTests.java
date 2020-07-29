package com.etoak;

import com.etoak.entity.User;
import com.etoak.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SystemUserApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

        User user = userService.queryUserById(2);
        System.out.println(user);
    }

}
