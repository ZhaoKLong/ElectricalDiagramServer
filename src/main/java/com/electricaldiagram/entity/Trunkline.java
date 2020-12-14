package com.electricaldiagram.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author Zkl
 * @Date 2020-10-09
 */

@Data
@TableName("trunkline")
public class Trunkline extends Model<Trunkline> {
    private static final long serialVersionUID = 4512761628476998720L;

    /**
     * id
     */
    @TableId(value = "trunkline_id", type = IdType.AUTO)
    private Integer trunklineId;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 线路名
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

    /**
     * 备注（环境信息）
     */
    private String remark;

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
