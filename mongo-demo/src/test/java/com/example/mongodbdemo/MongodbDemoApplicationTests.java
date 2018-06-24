package com.example.mongodbdemo;

import com.example.mongodbdemo.dao.UserDao;
import com.example.mongodbdemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbDemoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSave() {
        User user = new User();
        user.setId(1);
        user.setName("小明");
        user.setPassword("123456");
        userDao.saveUser(user);
    }

    @Test
    public void testFind() {
        User user = userDao.findUserByName("小明");
        System.out.println("user:" + user);

    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1);
        user.setName("静静");
        user.setPassword("654321");
        String s = userDao.updateUser(user);
        System.out.println(s);
    }

    @Test
    public void testUpdateById() {
        String s = userDao.updateUserById(1);
        System.out.println(s);
    }

    @Test
    public void testDelete() {
        userDao.deleteUserById(1);
    }

}
