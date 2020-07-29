package com.etoak;

import com.etoak.dto.NoteDto;
import com.etoak.entity.User;
import com.etoak.service.NoteService;
import com.etoak.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SystemUserApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private NoteService noteService;

    @Test
    void test01(){
        NoteDto noteDto = noteService.saveOrUpdateNote(null);
        System.out.println(noteDto);
    }
    @Test
    void contextLoads() {

        User user = userService.queryUserById(2);
        System.out.println(user);
    }

}
