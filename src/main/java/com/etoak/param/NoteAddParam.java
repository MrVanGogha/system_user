package com.etoak.param;

import lombok.Data;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 13:54 2020/7/29
 */
@Data
public class NoteAddParam {

    private Long id;

    private String noteTitle;

    private String noteContent;
    
}
