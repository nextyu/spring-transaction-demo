package com.nextyu.spring.transaction.demo.entity;

import lombok.Data;

@Data
public class User {
    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    public User(String name) {
        this.name = name;
    }
}