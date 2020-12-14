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
@TableName("equipment")
public class Equipment extends Model<Equipment> {
    private static final long serialVersionUID = 4481328994818361949L;

//    public Equipment() {
//    }

    /**
     * id
     */
    @TableId(value = "equipment_id", type = IdType.AUTO)
    private Long equipmentId;

    /**
     * 名字
     */
    private String name;

    /**
     * 电杆Id
     */
    private Long poleId;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 备注（环境信息）
     */
    private String remark;

    /**
     * 所属线路
     */
    private Integer trunklineId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modTime;

    /**
     * 设备指向的电杆id
     */
    private Long toPoleId;

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
