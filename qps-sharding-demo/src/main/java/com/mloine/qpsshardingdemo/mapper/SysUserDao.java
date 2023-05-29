package com.mloine.qpsshardingdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mloine.qpsshardingdemo.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUserDao extends BaseMapper<SysUser> {

    @Select("select * from sys_user where id = #{id}")
    SysUser cusSelectById(@Param("id") String id);
}
