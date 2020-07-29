package com.etoak.controller;

import com.etoak.dto.NoteDto;
import com.etoak.param.NoteAddParam;
import com.etoak.param.NoteQueryParam;
import com.etoak.service.NoteService;
import com.etoak.utils.PageableRestResult;
import com.etoak.utils.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 14:22 2020/7/29
 */
@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    /**
     * 保存或者更新记事本
     * @param param
     * @return
     */
    @PostMapping("/save")
    public RestResult<NoteDto> saveOrUpdate(NoteAddParam param){
        NoteDto noteDto = noteService.saveOrUpdateNote(param);
        return RestResult.success(noteDto);
    }

    /**
     * 获取记事本列表
     * @param param
     * @return
     */
    @GetMapping("/page")
    public PageableRestResult<List<NoteDto>> getNoteByPage(NoteQueryParam param){
        Page<NoteDto> page = noteService.queryNoteByPage(param);
        return PageableRestResult.success(page.getContent(),page.getTotalPages(),page.getTotalElements());
    }
}
