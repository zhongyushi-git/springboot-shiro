package com.zys.springbootshiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zys.springbootshiro.entity.Permissions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhongyushi
 * @date 2020/10/10 0010
 * @dec 描述
 */
public interface PermissionsDao extends BaseMapper<Permissions> {
    List<Permissions> getListByRoleId(@Param("roleId") String roleId);

    int delById(Integer id);
}
