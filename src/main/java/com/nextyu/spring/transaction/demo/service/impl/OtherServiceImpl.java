package com.nextyu.spring.transaction.demo.service.impl;

import com.nextyu.spring.transaction.demo.dao.UserMapper;
import com.nextyu.spring.transaction.demo.entity.User;
import com.nextyu.spring.transaction.demo.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * created on 2017-11-28 14:28
 *
 * @author nextyu
 */
@Service
public class OtherServiceImpl implements OtherService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void method1() {
        User user = new User("风魔小太郎");
        userMapper.insertSelective(user);
        if (true) {
            throw new RuntimeException("save 抛异常了");
        }
    }
}

/*

if (true) {
            throw new RuntimeException("OtherService.method1抛异常了");
        }

* */
