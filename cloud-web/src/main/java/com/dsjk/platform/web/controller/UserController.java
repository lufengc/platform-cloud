package com.dsjk.platform.web.controller;

import com.dsjk.platform.common.bean.user.SysUser;
import com.dsjk.platform.common.utils.BeanMapper;
import com.dsjk.platform.web.client.UserClient;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author fengcheng
 * @version 2017/2/28
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    private final UserClient userClient;

    @Autowired
    public UserController(UserClient userClient) {
        this.userClient = userClient;
    }

    @RequestMapping(value = "/sql/{id}", method = RequestMethod.GET)
    public SysUser getBySql(@PathVariable String id) {
        return userClient.getBySql(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SysUser get(@PathVariable String id) {
        return userClient.get(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public SysUser get(SysUser user) {
        Map map = BeanMapper.map(user, Map.class);
        return userClient.get(map);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<SysUser> getList(SysUser user) {
        Map map = BeanMapper.map(user, Map.class);
        return userClient.getList(map);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageInfo<SysUser> getPage(SysUser user) {
        Map map = BeanMapper.map(user, Map.class);
        return userClient.getPage(map);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(SysUser user) {
        userClient.save(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(SysUser user) {
        userClient.delete(user);
    }
}