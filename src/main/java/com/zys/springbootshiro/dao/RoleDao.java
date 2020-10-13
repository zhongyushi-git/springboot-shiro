package com.zys.springbootshiro.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zys.springbootshiro.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhongyushi
 * @date 2020/10/10 0010
 * @dec 描述
 */
public interface RoleDao extends BaseMapper<Role> {
    List<Role> getListByUserId(@Param("userId") Integer userId);
}
