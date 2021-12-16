package top.xinsin.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.xinsin.pojo.User;
import top.xinsin.services.UserService;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author xinxin
 * @Date 2021/12/11 18:06
 * @Version 1.0
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/api/login")
    public String login(@RequestBody User user,HttpServletResponse response) {
        return userService.canLogin(user,response).toString();
    }

    @PostMapping("/api/adduser")
    public String addUser(@RequestBody User user) {
        return userService.addUser(user).toString();
    }

    @PostMapping("/api/changepassword")
    public String changePassword(@RequestBody User user) {
        return userService.changePassword(user).toString();
    }

}
