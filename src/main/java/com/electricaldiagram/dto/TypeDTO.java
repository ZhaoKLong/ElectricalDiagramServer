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
@TableName("type")
public class TypeDTO {
    private static final long serialVersionUID = 7630050226742616755L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer typeId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
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
     * 汉字名称
     */
    @ApiModelProperty(value = "汉字名称")
    private String nickname;

}
