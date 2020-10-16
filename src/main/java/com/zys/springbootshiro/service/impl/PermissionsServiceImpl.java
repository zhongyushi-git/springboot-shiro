package com.zys.springbootshiro.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zys.springbootshiro.dao.PermissionsDao;
import com.zys.springbootshiro.entity.Permissions;
import com.zys.springbootshiro.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
    public IPage<Permissions> getList(String name, String code, Integer page, Integer limit) {
        QueryWrapper<Permissions> queryWrapper = new QueryWrapper<>();
        //根据条件模糊查询
        queryWrapper.like(StrUtil.isNotBlank(name), "permissions_name", name);
        queryWrapper.like(StrUtil.isNotBlank(code), "permissions_code", code);
        //根据id排序
        queryWrapper.orderByAsc("id");
        //设置分页
        IPage<Permissions> ipage = new Page<>(page, limit);
        return permissionsDao.selectPage(ipage, queryWrapper);

    }

    @Override
    public JSONObject saveData(Permissions permissions) {
        JSONObject json = new JSONObject();

        try {
            if (permissions.getId() == null) {
                permissionsDao.insert(permissions);
            } else {
                permissionsDao.updateById(permissions);
            }
            json.put("msg", "保存成功");
            json.put("status", true);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("status", false);
            //捕获唯一性约束异常
            if (e instanceof DuplicateKeyException) {
                json.put("msg", "权限编码已存在，请重新输入");
            } else {
                json.put("msg", "保存失败");
            }
        }
        return json;

    }

    @Override
    public Permissions getById(Integer id) {
        return permissionsDao.selectById(id);
    }

    @Override
    public int deleteById(Integer id) {
        return permissionsDao.delById(id);
    }
}
