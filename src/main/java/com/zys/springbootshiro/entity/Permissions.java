package com.zys.springbootshiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 权限实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "permissions")
public class Permissions {

    //id，自动增长
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    //权限名
    @TableField(value = "permissions_name")
    private String permissionsName;

    //权限编码
    @TableField(value = "permissions_code")
    private String permissionsCode;

}
