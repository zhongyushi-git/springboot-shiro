package com.zys.springbootshiro.controller;

import com.alibaba.fastjson.JSONObject;
import com.zys.springbootshiro.entity.User;
import com.zys.springbootshiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhongyushi
 * @date 2020/10/8 0008
 * @dec 用户信息
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public JSONObject login(String username,String password){
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        JSONObject json=new JSONObject();
        try{
            //用户认证
            subject.login(new UsernamePasswordToken(username,password));
            json.put("status",true);
            json.put("msg","登录成功");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            json.put("status",false);
            json.put("msg","登录失败，密码错误");
        }catch (UnknownAccountException e){
            e.printStackTrace();
            json.put("status",false);
            json.put("msg","登录失败,用户名不存在");
        }
        return json;
    }

    /**
     * 退出系统
     */
    @GetMapping("/logout")
    public JSONObject logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        JSONObject json=new JSONObject();
        json.put("status",true);
        json.put("msg","退出成功");
        return json;
    }

    //配置权限
    @RequiresPermissions("query")
    @GetMapping("/index")
    public String index() {
        return "index success!";
    }

    /**
     * 创建用户
     * @param user
     * @return
     */
    @RequiresPermissions("add")
    @GetMapping("/add")
    public String add(String username,String password) {
        User user=new User();
        user.setPassword(password).setUserName(username);
        int count = userService.createUser(user);
        return "add success!";
    }

    //权限
    @RequiresPermissions("update")
    @GetMapping("/update")
    public String update() {
        return "update success!";
    }

}
