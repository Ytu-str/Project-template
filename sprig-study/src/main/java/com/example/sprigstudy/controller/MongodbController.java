package com.example.sprigstudy.controller;

import com.example.sprigstudy.base.BaseResponse;
import com.example.sprigstudy.base.ResultUtils;
import com.example.sprigstudy.modle.eneity.User;
import com.example.sprigstudy.service.Impl.MongoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/Mongodb")
@RestController
@Api(tags="Mongodb")
public class MongodbController {

    @Resource
    private MongoService mongoService;

    @PostMapping("save")
    public void save(@RequestBody User user){
        mongoService.saveTest(user);
    }

    @GetMapping("query")
    public BaseResponse<User> queryMongodb(String name){
        User u = mongoService.findTestByName(name);
        return ResultUtils.success(u);
    }
}
