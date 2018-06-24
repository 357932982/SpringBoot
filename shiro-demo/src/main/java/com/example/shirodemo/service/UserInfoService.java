package com.example.shirodemo.service;

import com.example.shirodemo.entity.UserInfo;

public interface UserInfoService {
    public UserInfo findByUsername(String username);
}
