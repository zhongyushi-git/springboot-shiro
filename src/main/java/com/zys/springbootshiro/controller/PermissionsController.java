package com.zys.springbootshiro.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zys.springbootshiro.entity.Permissions;
import com.zys.springbootshiro.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
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

    /**
     * 查询列表
     *
     * @param name
     * @param code
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/list")
    public JSONObject getList(String name, String code, Integer page, Integer limit) {
        IPage<Permissions> pages = permissionsService.getList(name, code, page, limit);
        JSONObject json = new JSONObject();
        json.put("data", pages.getRecords());
        json.put("status", true);
        json.put("code", 0);
        json.put("count", pages.getTotal());
        return json;
    }

    /**
     * 保存数据，添加或修改
     *
     * @param permissions
     * @return
     */
    @PostMapping("/save")
    public JSONObject saveData(@RequestBody Permissions permissions) {
        return permissionsService.saveData(permissions);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/one/{id}")
    public JSONObject getById(@PathVariable("id") Integer id) {
        JSONObject json = new JSONObject();
        Permissions permissions = permissionsService.getById(id);
        json.put("data", permissions);
        json.put("status", true);
        return json;
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @PostMapping("/del")
    public JSONObject deleteById(Integer id) {
        permissionsService.deleteById(id);
        JSONObject json = new JSONObject();
        json.put("msg", "删除成功");
        json.put("status", true);
        return json;
    }
}
