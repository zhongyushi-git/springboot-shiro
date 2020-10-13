package com.zys.springbootshiro.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongyushi
 * @date 2020/10/8 0008
 * @dec shiro配置
 */
@Configuration
public class ShiroConfig {


    //自定义realm
    @Bean
    public Realm getRealm(){
        MyRealm myRealm = new MyRealm();
        //修改凭证校验匹配器
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //设置算法是md5,散列长度是1024
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return myRealm;
    }

    //web安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //设置realm
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    //shiro过滤器,拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置受限资源
        Map<String,String> map=new HashMap<>();
        //设置登录的页面
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //设置登录成功的页面
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        //anon表示不拦截的请求。注意：anon写在authc前面，否则不生效
        map.put("/login","anon");
        map.put("/lib/**","anon");
        map.put("/css/**","anon");
        map.put("/js/**","anon");
        //authc表示请求此资源要认证和授权,拦截所有
        map.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }



}
