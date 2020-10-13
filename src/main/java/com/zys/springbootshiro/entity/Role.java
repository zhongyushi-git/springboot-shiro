package com.zys.springbootshiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 角色实体
 * 一个用户有多个角色，一个角色有多个权限
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "role")
public class Role {

    //id，自动增长
    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    //角色名
    @TableField(value = "role_name")
    private String roleName;

    //角色编码
    @TableField(value = "role_code")
    private String roleCode;

    @TableField(exist = false)
    //角色对应权限集合
    private List<Permissions> permissions;
}
