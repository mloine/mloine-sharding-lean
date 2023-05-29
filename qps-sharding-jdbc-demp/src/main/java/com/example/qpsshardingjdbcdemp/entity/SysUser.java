package com.example.qpsshardingjdbcdemp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 *
 * @author
 * @since 2019-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 2632552477826087575L;

    @TableField
    private Long id;

    /**
     * 员工编号
     */
    private String staffNo;

    /**
     * 员工名称(母语名称)
     */
    private String name;

    /**
     * 性别 1男 2女
     */
    private Integer sex;


    /**
     * 手机
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;


    /**
     * 备注
     */
    private String remark;


    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;

    /**
     * 最后更新人ID
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer updateBy;

    /**
     * 创建人名称
     */
    @TableField(fill = FieldFill.INSERT)
    private String createByName;

    /**
     * 最后修改人名称
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateByName;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date updateTime;



}
