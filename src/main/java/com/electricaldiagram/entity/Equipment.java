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
     * 电杆名字
     */
    private Long poleId;

    /**
     * 类型
     */
    private Long type;

    /**
     * 备注（环境信息）
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modTime;

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
