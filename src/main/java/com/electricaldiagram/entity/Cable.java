package com.electricaldiagram.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author Zkl
 * @Date 2020-10-09
 */

@Data
@TableName("cable")
public class Cable extends Model<Cable> {
    private static final long serialVersionUID = 8553594351034978434L;

    /**
     * 电缆id
     */
    @TableId(value = "cable_id", type = IdType.AUTO)
    private Long cableId;

    /**
     * 名字
     */
    private String name;

    /**
     * 上一电杆id
     */
    private Long prePoleId;

    /**
     * 下一电杆id
     */
    private Long nextPoleId;

    /**
     * 电缆长度（m）
     */
    private Double length;

    /**
     * 电缆类型(type表)
     */
    private Long type;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modTime;

    /**
     * 备注（环境信息）
     */
    private String remark;

    /**
     * 所属线路
     */
    private Long trunklineId;

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
