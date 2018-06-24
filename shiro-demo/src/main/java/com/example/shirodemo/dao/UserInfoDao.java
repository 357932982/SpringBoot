package com.example.shirodemo.dao;

import com.example.shirodemo.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<UserInfo, Integer> {
    /**通过username查找用户信息;*/
    public UserInfo findByUserName(String userName);
}
