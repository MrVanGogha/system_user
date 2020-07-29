package com.etoak.service;

import com.etoak.dao.NoteDao;
import com.etoak.dto.NoteDto;
import com.etoak.entity.Note;
import com.etoak.param.NoteAddParam;
import com.etoak.param.NoteQueryParam;
import com.etoak.utils.BeanConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 13:55 2020/7/29
 */
@Service
public class NoteService {
    @Autowired
    private NoteDao noteDao;

    /**
     * 添加或者更新记事本
     * @param param
     * @return
     */
    public NoteDto saveOrUpdateNote(NoteAddParam param){
        Note note = new Note();
        if(param.getId() == null){
            note.setNoteTitle("未命名笔记");
            note.setCreateTime(LocalDateTime.now());
            note.setModifyTime(LocalDateTime.now());
        }else {
            note = noteDao.findById(param.getId()).get();
            BeanUtils.copyProperties(param,note);
            note.setModifyTime(LocalDateTime.now());
        }
        Note save = noteDao.save(note);
        return BeanConvert.convertBean(save,NoteDto.class);
    }

    /**
     * 分页查询记事本信息
     */

    public Page<NoteDto> queryNoteByPage(NoteQueryParam param){
        Sort sort = Sort.by(Sort.Direction.DESC,"modifyTime");
        Pageable pageable = PageRequest.of(param.getPageNum()-1,param.getPageSize(),sort);
        Page<Note> notes = noteDao.findAll(pageable);
        return notes.map(note -> BeanConvert.convertBean(note,NoteDto.class));
    }
}
