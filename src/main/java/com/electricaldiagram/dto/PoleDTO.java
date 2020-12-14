package com.electricaldiagram.dto;

import com.baomidou.mybatisplus.annotations.TableName;
import com.electricaldiagram.entity.Equipment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author Zkl
 * @Date 2020-10-09
 */

@Data
@TableName("pole")
public class PoleDTO {
    private static final long serialVersionUID = 8156822213796780420L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long poleId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private Double longitude;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private Double latitude;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date modTime;

    /**
     * 备注（环境信息）
     */
    @ApiModelProperty(value = "备注（环境信息）")
    private String remark;

    /**
     * 照片网络路径
     */
    @ApiModelProperty(value = "照片网络路径")
    private String photosUrl;

    /**
     * 所属线路
     */
    @ApiModelProperty(value = "所属线路")
    private Integer trunklineId;

    /**
     * 所属线路名称
     */
    @ApiModelProperty(value = "所属线路名称")
    private String trunklineName;

    /**
     * 线路列表
     */
    @ApiModelProperty(value = "线路列表")
    private List<Equipment> equipmentList;

    /**
     * 是否为厂站
     */
    @ApiModelProperty(value = "是否为厂站")
    private Integer isFactory;
}
