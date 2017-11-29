package com.nextyu.spring.transaction.demo;

import com.nextyu.spring.transaction.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTransactionDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void save() {
        userService.save();
    }

}
