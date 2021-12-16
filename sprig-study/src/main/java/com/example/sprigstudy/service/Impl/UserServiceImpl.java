package com.example.sprigstudy.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sprigstudy.exception.BusinessException;
import com.example.sprigstudy.exception.ErrorCodeEnum;
import com.example.sprigstudy.mapper.UserMapper;
import com.example.sprigstudy.modle.eneity.User;
import com.example.sprigstudy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized void transactionalTest(User user){
        userMapper.insert(user);
        throw new BusinessException(ErrorCodeEnum.REQUEST_PARAMS_ERROR);
    }
}
