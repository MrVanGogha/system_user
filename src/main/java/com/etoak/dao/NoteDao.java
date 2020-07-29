package com.etoak.dao;

import com.etoak.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 13:53 2020/7/29
 */
public interface NoteDao extends JpaRepository<Note,Long>, JpaSpecificationExecutor<Note> {

}
