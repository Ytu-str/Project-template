package com.example.sprigstudy.service.Impl;

import com.example.sprigstudy.modle.eneity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MongoService {

    @Resource
    private MongoTemplate mongoTemplate;


    /**
     * 创建对象
     */
    public void saveTest(User user) {
        mongoTemplate.save(user);
    }
    /**
     * 根据用户名查询对象
     * @return
     */
    public User findTestByName(String name) {
        Query query=new Query(Criteria.where("userName").is(name));
        User user =  mongoTemplate.findOne(query , User.class);
        return user;
    }
    /**
     * 更新对象
     */
    public void updateTest(User user) {
        Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update= new Update().set("passWord", user.getPassWord()).set("userName", user.getUserName());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,User.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,TestEntity.class);
    }

    /**
     * 删除对象
     * @param id
     */
    public void deleteTestById(Integer id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,User.class);
    }

}
