package com.electricaldiagram.dto;

import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author Zkl
 * @Date 2020-10-09
 */

@Data
@TableName("trunkline")
public class TrunklineDTO {
    private static final long serialVersionUID = 3767906083849399114L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer trunklineId;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Integer parentId;

    /**
     * 线路名
     */
    @ApiModelProperty(value = "线路名")
    private String name;

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

}
