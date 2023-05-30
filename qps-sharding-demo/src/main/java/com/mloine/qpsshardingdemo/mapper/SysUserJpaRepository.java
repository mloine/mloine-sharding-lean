package com.mloine.qpsshardingdemo.mapper;

import com.mloine.qpsshardingdemo.entity.SysUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SysUserJpaRepository extends CrudRepository<SysUser,Long> {
}
