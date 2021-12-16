package com.example.sprigstudy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sprigstudy.base.BaseResponse;
import com.example.sprigstudy.base.ResultUtils;
import com.example.sprigstudy.exception.BusinessException;
import com.example.sprigstudy.exception.ErrorCodeEnum;
import com.example.sprigstudy.modle.eneity.User;
import com.example.sprigstudy.service.Impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/Test")
@CrossOrigin
@Api(tags="用户")
public class TestErrorController {

    @Resource
    private UserServiceImpl userService;

    @ApiOperation(value = "添加用户",notes = "id可已为空")
    @PostMapping("/add")
    public BaseResponse<Integer> add(@RequestBody User user){
        if (user == null){
            throw new BusinessException(ErrorCodeEnum.REQUEST_PARAMS_ERROR);
        }
        userService.save(user);
        log.info("save success");
        return ResultUtils.success(user.getId());
    }

    @ApiOperation(value = "Get单参数测试")
    @GetMapping("/getOne")
    public BaseResponse<Integer> hello(@RequestParam("num")String num){
        System.out.println(Integer.parseInt(num));
        log.info("link success getOne");
        return ResultUtils.success(100);
    }

    @ApiOperation(value = "Post单参数测试")
    @PostMapping("/postOne")
    public BaseResponse<Integer> hello(@RequestBody Map<String,String> map){
        System.out.println(Integer.parseInt(map.get("num")));
        log.info("link success postOne");
        return ResultUtils.success(100);
    }

    @ApiOperation(value = "查询用户")
    @GetMapping("/query")
    public BaseResponse<? extends Collection> query(){
        QueryWrapper<User> query = new QueryWrapper<>();
        List<User> list = userService.list(query);
        log.info("query success");
        return ResultUtils.success(list);
    }

    @GetMapping("/queryList")
    public List<User> queryList(){
        QueryWrapper<User> query = new QueryWrapper<>();
        List<User> list = userService.list(query);
        log.info("query success");
        return list;
    }
    @PostMapping("/trans")
    public BaseResponse<Integer> transactional(@RequestBody User user){
        if (user==null){
            return ResultUtils.error(200,"参数错误");
        }else {
            userService.transactionalTest(user);
            return ResultUtils.success(100);
        }
    }

}
