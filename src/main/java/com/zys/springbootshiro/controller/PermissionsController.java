package com.zys.springbootshiro.controller;

import com.alibaba.fastjson.JSONObject;
import com.zys.springbootshiro.entity.Permissions;
import com.zys.springbootshiro.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhongyushi
 * @date 2020/10/12 0012
 * @dec 权限接口
 */
@RestController
@RequestMapping("/api/permission")
public class PermissionsController {

    @Autowired
    private PermissionsService permissionsService;

    @GetMapping("/list")
    public JSONObject getList(String name,String code,Integer page,Integer limit){
        List<Permissions> list = permissionsService.getList();
        JSONObject json=new JSONObject();
        json.put("data",list);
        json.put("status",true);
        json.put("code",0);
        json.put("count",3);
        return json;
    }
}
