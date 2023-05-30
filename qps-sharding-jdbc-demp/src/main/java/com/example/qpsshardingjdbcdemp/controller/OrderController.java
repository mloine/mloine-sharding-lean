package com.example.qpsshardingjdbcdemp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.qpsshardingjdbcdemp.entity.Order;
import com.example.qpsshardingjdbcdemp.entity.SysUser;
import com.example.qpsshardingjdbcdemp.mapper.OrderDao;
import com.example.qpsshardingjdbcdemp.mapper.SysUserDao;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderDao orderDao;

    @GetMapping("/{id}")
    public Order user(@PathVariable Long id) {
        return orderDao.selectById(id);
    }


    @PostMapping("/pages")
    public Object user() {
        Page<Order> pageCondition = new Page<Order>().setCurrent(1).setSize(10);

        return orderDao.selectPage(
                pageCondition
                , new QueryWrapper<Order>().orderByAsc("orderId")
        );
    }


    @PutMapping("save")
    public Object add() {
        Order input = new Order();

        // faker
        Faker faker = new Faker();
        input.setUserId(faker.number().randomDigitNotZero());
        input.setOrderId(faker.number().randomDigitNotZero());
        input.setAddressId(faker.number().randomDigitNotZero());
        input.setStatus(faker.code().asin());
        orderDao.insert(input);

        return input;
    }
}
