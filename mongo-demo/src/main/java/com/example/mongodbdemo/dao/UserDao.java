package com.example.mongodbdemo.dao;

import com.example.mongodbdemo.entity.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;


@Component
public class UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     *
     * @param user: user对象
     */
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询
     *
     * @param name
     * @return
     */
    public User findUserByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    /**
     * 更新对象
     *
     * @param user
     * @return
     */
    public String updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("name", user.getName()).set("password", user.getPassword());
        //更新查询返回结果集的第一条
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        //更新查询返回结果的所有
        //mongoTemplate.updateMulti(query, update, User.class);
        return result.toString();
    }

    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    public String updateUserById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update().set("name", "花花");
        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        return result.toString();
    }

    public void deleteUserById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
    }

}
