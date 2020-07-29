package com.etoak.service;


import com.etoak.dao.UserDao;
import com.etoak.dto.UserDto;
import com.etoak.entity.User;
import com.etoak.param.UserQueryParam;
import com.etoak.utils.BeanConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @Description:
 * @Author: ove
 * @Email: Mr_VanGogh@yeah.net
 * @Date: Create in 14:25 2020/7/13
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 添加用户
     * @param user
     * @return
     */
    public User addUser(User user) {
        user.setCreateTime(new Date());
        User save = userDao.save(user);
        return user;
    }

    /**
     * 根据主键id查询用户
     * @param id
     * @return
     */
    public User queryUserById(Integer id) {
        Optional<User> optionalUser = userDao.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        return null;
    }

    /**
     * 根据主键删除用户
     * @param id
     * @return
     */
    public String deleteUserById(Integer id) {
        Optional<User> optionalUser = userDao.findById(id);
        if(optionalUser.isPresent()){
            userDao.deleteById(id);
            return "删除成功";
        }
        return "用户不存在";
    }

    /**
     * 根据主键更新用户
     * @param user
     */
    public void updateUser(User user) {
        userDao.findById(user.getId()).ifPresent(new Consumer<User>() {
            @Override
            public void accept(User user1) {
                BeanUtils.copyProperties(user,user1);
                userDao.save(user1);
            }
        });
    }

    /**
     * 分页查询
     * @param param
     * @return
     */
    public Page<UserDto> queryByPage(UserQueryParam param) {
        Pageable pageable = PageRequest.of(param.getPageNum()-1,param.getPageSize());
        Page<User> users = userDao.findAll((root, criteriaQuery, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(!StringUtils.isEmpty(param.getUserName())){
                predicates.add(cb.like(root.get("userName"),"%"+param.getUserName()+"%"));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        }, pageable);
        return users.map(user -> BeanConvert.convertBean(user,UserDto.class));
    }
}
