package com.wxl.springbootmongodb.dao;

import com.wxl.springbootmongodb.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveUser() {
        UserEntity user=new UserEntity();
        user.setId(2l);
        user.setName("小明");
        user.setPwd("fffooo123");
        userDao.saveUser(user);
    }

    @Test
    public void findUserByUserName(){
        UserEntity user= userDao.findUserByUserName("小明");
        System.out.println("user is "+user);
    }

}
