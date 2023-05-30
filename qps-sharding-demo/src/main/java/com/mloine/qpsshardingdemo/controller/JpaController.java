package com.mloine.qpsshardingdemo.controller;


import com.github.javafaker.Faker;
import com.mloine.qpsshardingdemo.entity.SysUser;
import com.mloine.qpsshardingdemo.mapper.SysUserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/user/jpa")
public class JpaController {


    @Autowired
    SysUserJpaRepository sysUserJpaRepository;

    @GetMapping("/{id}")
    public SysUser user(@PathVariable Long id) {
        Optional<SysUser> byId = sysUserJpaRepository.findById(id);
        return byId.get();
    }


    @PostMapping("/pages")
    public Object user() {
        Iterable<SysUser> all = sysUserJpaRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
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

        sysUserJpaRepository.save(sysUser);
        return sysUser;
    }


}

