package com.electricaldiagram.controller.equipment;

import com.electricaldiagram.common.ResultData;
import com.electricaldiagram.service.EquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Zhaokl
 * @create: 2020-10-09 17:41
 **/
@Api(tags = "设备管理模块")
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    /**
     * 根据ID查询设备
     *
     * @param equipmentId 设备ID
     * @return
     */
    @ApiOperation(value = "根据ID查询设备")
    @GetMapping("/{equipmentId}")
    public ResultData getEquipmentListByRole(@PathVariable(value = "equipmentId") final Long equipmentId) {
        return ResultData.success(this.equipmentService.selectEquipmentById(equipmentId));
    }

    /**
     * 根据线路查询设备
     *
     * @param trunklineId 线路Id
     * @return
     */
    @ApiOperation(value = "根据线路查询设备")
    @GetMapping("/selectByTrunkline/{trunklineId}")
    public ResultData selectPole(@ApiParam(name = "trunklineId", value = "0为所有线路", required = false) @PathVariable(value = "trunklineId", required = false) final Integer trunklineId) {
        return ResultData.success(this.equipmentService.selectEquipmentByTrunklineId(trunklineId));
    }
}
