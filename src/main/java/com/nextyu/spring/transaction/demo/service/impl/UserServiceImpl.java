package com.nextyu.spring.transaction.demo.service.impl;


import com.nextyu.spring.transaction.demo.dao.UserMapper;
import com.nextyu.spring.transaction.demo.entity.User;
import com.nextyu.spring.transaction.demo.service.OtherService;
import com.nextyu.spring.transaction.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OtherService otherService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save() {

        otherService.method1();

        User user = new User("服部半藏");
        userMapper.insertSelective(user);


    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void method1() {
        User user = new User("宫本武藏");
        userMapper.insertSelective(user);
    }




}