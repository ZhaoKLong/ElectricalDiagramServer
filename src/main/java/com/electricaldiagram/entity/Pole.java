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
@TableName("pole")
public class Pole extends Model<Pole> {
    private static final long serialVersionUID = 8061785464739476931L;

    /**
     * id
     */
    @TableId(value = "pole_id", type = IdType.AUTO)
    private Long poleId;

    /**
     * 名称
     */
    private String name;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

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
     * 照片网络路径
     */
    private String photosUrl;

    /**
     * 所属线路
     */
    private Long trunklineId;

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
