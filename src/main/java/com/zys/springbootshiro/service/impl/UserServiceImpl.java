package com.zys.springbootshiro.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zys.springbootshiro.dao.UserDao;
import com.zys.springbootshiro.entity.Permissions;
import com.zys.springbootshiro.entity.Role;
import com.zys.springbootshiro.entity.User;
import com.zys.springbootshiro.service.PermissionsService;
import com.zys.springbootshiro.service.RoleService;
import com.zys.springbootshiro.service.UserService;
import com.zys.springbootshiro.util.SaltUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhongyushi
 * @date 2020/10/10 0010
 * @dec 描述
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionsService permissionsService;

    @Override
    public User getUserByName(String username) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", username);
        User user = userDao.selectOne(userQueryWrapper);
        List<Role> roleList = roleService.getListByUserId(user.getId());
        for (Role role : roleList) {
            List<Permissions> permissionsList = permissionsService.getListByRoleId(role.getId());
            role.setPermissions(permissionsList);
        }
        user.setRoles(roleList);
        System.out.println(user.toString());
        return user;
    }

    @Override
    public int createUser(User user) {
        //生成随机数
        String salt = SaltUtil.createSalt(16);
        user.setSalt(salt);
        //对密码进行md5加密，加盐，hash化
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setPassword(md5Hash.toHex());
        return userDao.insert(user);
    }

    @Override
    public User getLoginUser() {
        Subject subject = SecurityUtils.getSubject();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", subject.getPrincipal().toString());
        User loginUser = userDao.selectOne(userQueryWrapper);
        return loginUser;
    }


    /**
     * 模拟数据库查询
     *
     * @param userName 用户名
     * @return User
     */
//    private User getMapByName(String userName) {
//        Permissions permissions1 = new Permissions(1, "query");
//        Permissions permissions2 = new Permissions(2, "add");
//        Set<Permissions> permissionsSet = new HashSet<>();
//        permissionsSet.add(permissions1);
//        permissionsSet.add(permissions2);
//        Role role = new Role("1", "admin", permissionsSet);
//        Set<Role> roleSet = new HashSet<>();
//        roleSet.add(role);
//        User user = new User(1, "wsll", "123456", roleSet);
//        Map<String, User> map = new HashMap<>();
//        map.put(user.getUserName(), user);
//
//        Set<Permissions> permissionsSet1 = new HashSet<>();
//        permissionsSet1.add(permissions1);
//        Role role1 = new Role("2", "user", permissionsSet1);
//        Set<Role> roleSet1 = new HashSet<>();
//        roleSet1.add(role1);
//        User user1 = new User(2, "zhangsan", "123456", roleSet1);
//        map.put(user1.getUserName(), user1);
//        return map.get(userName);
//    }
}
