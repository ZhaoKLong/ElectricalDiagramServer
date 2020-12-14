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
@TableName("equipment")
public class EquipmentDTO {
    private static final long serialVersionUID = 7568696130980053252L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long equipmentId;

    /**
     * 名字
     */
    @ApiModelProperty(value = "名字")
    private String name;

    /**
     * 电杆
     */
    @ApiModelProperty(value = "电杆")
    private Pole pole;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private Integer type;

    /**
     * 类型名称
     */
    @ApiModelProperty(value = "类型名称")
    private Integer typeName;

    /**
     * 备注（环境信息）
     */
    @ApiModelProperty(value = "备注（环境信息）")
    private String remark;

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
     * 设备指向的电杆id
     */
    @ApiModelProperty(value = "设备指向的电杆id")
    private Long toPoleId;

}
