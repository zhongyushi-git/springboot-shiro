package com.zys.springbootshiro.service.impl;

import com.zys.springbootshiro.dao.PermissionsDao;
import com.zys.springbootshiro.entity.Permissions;
import com.zys.springbootshiro.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongyushi
 * @date 2020/10/10 0010
 * @dec 描述
 */
@Service
public class PermissionsServiceImpl implements PermissionsService {

    @Autowired
    private PermissionsDao permissionsDao;

    @Override
    public List<Permissions> getListByRoleId(String id) {
        return permissionsDao.getListByRoleId(id);
    }

    @Override
    public List<Permissions> getList() {
        return permissionsDao.selectList(null);
    }
}
