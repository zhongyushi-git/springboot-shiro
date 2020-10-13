package com.zys.springbootshiro.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zys.springbootshiro.entity.Permissions;
import com.zys.springbootshiro.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        IPage<Permissions> pages = permissionsService.getList(name,code,page,limit);
        JSONObject json=new JSONObject();
        json.put("data",pages.getRecords());
        json.put("status",true);
        json.put("code",0);
        json.put("count",pages.getTotal());
        return json;
    }

    @PostMapping("/add")
    public JSONObject addData(@RequestBody Permissions permissions){
        int count=permissionsService.addData(permissions);
        JSONObject json=new JSONObject();
        json.put("msg","添加成功");
        json.put("status",true);
        return json;
    }
}
