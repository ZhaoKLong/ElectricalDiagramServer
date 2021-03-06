package com.electricaldiagram.controller.type;

import com.electricaldiagram.common.ResultData;
import com.electricaldiagram.entity.Type;
import com.electricaldiagram.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: Zhaokl
 * @create: 2020-10-09 17:41
 **/
@Api(tags = "设备类型管理模块")
@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    /**
     * 根据ID查询设备类型
     *
     * @param typeId 设备类型ID
     * @return
     */
    @ApiOperation(value = "根据ID查询设备类型")
    @GetMapping("/{typeId}")
    public ResultData getTypeListByRole(@PathVariable(value = "typeId") final Long typeId) {
        return ResultData.success(this.typeService.selectTypeById(typeId));
    }

    /**
     * 新增设备类型
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "新增设备类型")
    @PostMapping()
    public ResultData createType(@RequestBody final Type type) {
        return ResultData.success(this.typeService.createType(type));
    }
}
