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
@TableName("type")
public class Type extends Model<Type> {
    private static final long serialVersionUID = 1987817367278813301L;

    /**
     * id
     */
    @TableId(value = "type_id", type = IdType.AUTO)
    private Long typeId;

    /**
     * 名称
     */
    private String name;

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
