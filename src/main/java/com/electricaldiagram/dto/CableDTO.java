package com.electricaldiagram.dto;

import com.baomidou.mybatisplus.annotations.TableName;
import com.electricaldiagram.entity.Pole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author Zkl
 * @Date 2020-10-09
 */

@Data
@TableName("cable")
public class CableDTO {
    private static final long serialVersionUID = 8697688530351960631L;

    /**
     * 电缆id
     */
    @ApiModelProperty(value = "电缆id")
    private Long cableId;

    /**
     * 名字
     */
    @ApiModelProperty(value = "名字")
    private String name;

    /**
     * 电缆长度（m）
     */
    @ApiModelProperty(value = "电缆长度（m）")
    private Double length;

    /**
     * 电缆类型(type表)
     */
    @ApiModelProperty(value = "电缆类型(type表)")
    private Long type;

    /**
     * 备注（环境信息）
     */
    @ApiModelProperty(value = "备注（环境信息）")
    private String remark;

    /**
     * 所属线路
     */
    @ApiModelProperty(value = "所属线路")
    private Integer trunklineId;

    /**
     * 前一个电杆
     */
    @ApiModelProperty(value = "前一个电杆")
    private Pole prev;

    /**
     * 后一个电杆
     */
    @ApiModelProperty(value = "后一个电杆")
    private Pole next;

    /**
     * 是否为主干线
     */
    @ApiModelProperty(value = "是否为主干线")
    private Integer isMain;

}
