package com.example.qpsshardingjdbcdemp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.qpsshardingjdbcdemp.entity.SysUser;
import com.example.qpsshardingjdbcdemp.mapper.SysUserDao;
import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class ApiController {

    @Autowired
    SysUserDao sysUserDao;

    @GetMapping("/{id}")
    public SysUser user(@PathVariable String id) {

//        return sysUserDao.selectOne(new QueryWrapper<SysUser>().eq("id", id));
        return sysUserDao.cusSelectById(id);
//        return sysUserDao.selectById(id);
    }


    @PostMapping("/pages")
    public Object user() {
        Page<SysUser> pageCondition = new Page<SysUser>().setCurrent(1).setSize(10);

        return sysUserDao.selectPage(
                pageCondition
                , new QueryWrapper<SysUser>().orderByAsc("id")
        );
    }


    @PutMapping("save")
    public Object add() {
        SysUser sysUser = new SysUser();

        // faker
        Faker faker = new Faker();
        sysUser.setStaffNo(faker.code().ean13());
        sysUser.setMobile(faker.phoneNumber().phoneNumber());
        sysUser.setName(faker.name().name());
        sysUser.setSex(faker.number().numberBetween(0, 1));
        sysUser.setEmail(String.format("%s@qq.com", faker.code().asin()));
        sysUser.setCreateBy(1);
        sysUser.setCreateTime(new Date());
        sysUser.setCreateByName("admin");

        sysUserDao.insert(sysUser);

        return sysUser;
    }
}
