package com.zys.springbootshiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author zhongyushi
 * @date 2020/10/10 0010
 * @dec 用户实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "user")
public class User {
    //id，自动增长
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    //用户名，是唯一的
    @TableField(value = "username")
    private String userName;

    //密码
    @TableField(value = "password")
    private String password;

    //盐salt
    @TableField(value = "salt")
    private String salt;

    //用户对应的角色集合，不映射数据库
    @TableField(exist = false)
    private List<Role> roles;
}
