package com.zys.springbootshiro.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zys.springbootshiro.entity.Permissions;

import java.util.List;

/**
 * @author zhongyushi
 * @date 2020/10/10 0010
 * @dec 描述
 */
public interface PermissionsService {
    List<Permissions> getListByRoleId(String id);

    IPage<Permissions> getList(String name, String code, Integer page, Integer limit);

    int addData(Permissions permissions);
}
