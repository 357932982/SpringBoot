package com.example.shirodemo.service;

import com.example.shirodemo.dao.UserInfoDao;
import com.example.shirodemo.entity.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String userName) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUserName(userName);
    }
}
