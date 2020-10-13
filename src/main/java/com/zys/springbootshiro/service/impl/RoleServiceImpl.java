package com.zys.springbootshiro.service.impl;

import com.zys.springbootshiro.dao.RoleDao;
import com.zys.springbootshiro.entity.Role;
import com.zys.springbootshiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongyushi
 * @date 2020/10/10 0010
 * @dec 描述
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getListByUserId(Integer id) {
        return roleDao.getListByUserId(id);
    }
}
