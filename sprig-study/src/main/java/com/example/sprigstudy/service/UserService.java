package com.example.sprigstudy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sprigstudy.modle.eneity.User;



public interface UserService extends IService<User> {
    void transactionalTest(User user);
}
