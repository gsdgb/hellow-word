package org.example.controller;

import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping ("/users")
    public Result list(){
        System.out.println("查询USER数据");
        List<User> userlist = userService.findAll();
        return Result.success(userlist);
    }

    @DeleteMapping ("/users")
    public Result delete(Integer id){
        System.out.println("删除USER数据" + id);
        if (id == null){
            return Result.fail("id不能为空");
        }
        userService.delete(id);
        return Result.success();
    }
    @PostMapping ("/users")
    public Result save(@RequestBody User user){//@RequestBody将请求体中json格式的数据转成java对象
        System.out.println("保存USER数据" + user);
        if (user.getUsername() == null || user.getPassword() == null){
            return Result.fail("用户名或密码不能为空");
        }
        userService.save(user);
        return Result.success();
    }
}
