package com.etoak.dao;

import com.etoak.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 14:25 2020/7/13
 */
public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
}
