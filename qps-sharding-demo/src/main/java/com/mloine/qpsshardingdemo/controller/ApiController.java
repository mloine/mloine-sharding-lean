package com.mloine.qpsshardingdemo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.javafaker.Faker;
import com.mloine.qpsshardingdemo.entity.SysUser;
import com.mloine.qpsshardingdemo.mapper.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class ApiController {

    @Autowired
    SysUserDao sysUserDao;

    @GetMapping("/{id}/{staffNo}")
    public SysUser user(@PathVariable String id, @PathVariable String staffNo) {

        return sysUserDao.selectOne(new QueryWrapper<SysUser>().eq("id", id).eq("staff_no", staffNo));
//        return sysUserDao.cusSelectById(id);
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


    @GetMapping("origin/{id}")
    public SysUser originJdbcSelect(@PathVariable String id) {
        Connection conn = null;
        Statement stmt = null;
        SysUser blog = new SysUser();

        try {
            // 1.注册 JDBC 驱动
            Class.forName("org.postgresql.Driver");

            // 2.获取一个Connection
            conn = DriverManager.getConnection("jdbc:postgresql://kinneysharding001:3307/sharding_db", "root", "root");

            // 3.创建一个Statement对象
            stmt = conn.createStatement();
            String sql = String.format("SELECT * FROM sys_user where id = %s", id);
            // 4.execute()方法执行SQL，得到一个ResultSet结果集
            ResultSet rs = stmt.executeQuery(sql);
            // 5.通过遍历ResultSet结果集得到数据，给POJO赋值处理数据，最终返回POJO
            while (rs.next()) {
                Long bid = rs.getLong("id");
                String name = rs.getString("name");
                String authorId = rs.getString("staff_no");

                blog.setStaffNo(authorId);
                blog.setId(bid);
                blog.setName(name);
            }
            System.out.println(blog);

            // 6.关闭数据库相关资源，包括ResultSet、Statement、Connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6.关闭数据库相关资源，包括ResultSet、Statement、Connection
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return blog;
    }
}
