package com.wxl.springbootmongodb.dao;

import com.wxl.springbootmongodb.entity.UserEntity;

public interface UserDao {
    void saveUser(UserEntity user);
    UserEntity findUserByUserName(String userName);
    void updateUser(UserEntity user);
    void deleteUserById(Long id);
}
