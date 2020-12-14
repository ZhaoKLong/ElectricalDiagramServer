package com.electricaldiagram.vo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.electricaldiagram.entity.Equipment;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @description:
 * @author: Zhaokl
 * @create: 2020-10-10 17:39
 **/
@Data
@TableName("pole")
@ApiModel("PoleVO")
public class PoleVO {
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
    private Integer trunklineId;

    /**
     * 设备列表
     */
    private Equipment[] equipmentList;
}
