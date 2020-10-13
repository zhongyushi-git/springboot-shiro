package com.zys.springbootshiro.service;

import com.zys.springbootshiro.entity.Role;

import java.util.List;

/**
 * @author zhongyushi
 * @date 2020/10/10 0010
 * @dec 描述
 */
public interface RoleService {
    List<Role> getListByUserId(Integer id);
}
