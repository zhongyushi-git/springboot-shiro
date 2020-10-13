package com.zys.springbootshiro.service;

import com.zys.springbootshiro.entity.Permissions;

import java.util.List;

/**
 * @author zhongyushi
 * @date 2020/10/10 0010
 * @dec 描述
 */
public interface PermissionsService {
    List<Permissions> getListByRoleId(String id);

    List<Permissions> getList();

}
