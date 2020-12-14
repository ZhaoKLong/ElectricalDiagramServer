package com.electricaldiagram.controller.cable;

import com.electricaldiagram.common.ResultData;
import com.electricaldiagram.dto.CableDTO;
import com.electricaldiagram.service.CableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: Zhaokl
 * @create: 2020-10-09 17:41
 **/
@Api(tags = "电缆管理模块")
@RestController
@RequestMapping("/cable")
public class CableController {
    @Autowired
    private CableService cableService;

    /**
     * 根据ID查询电缆
     *
     * @param cableId 电缆ID
     * @return
     */
    @ApiOperation(value = "根据ID查询电缆")
    @GetMapping("/{cableId}")
    public ResultData getCableListByRole(@PathVariable(value = "cableId") final Long cableId) {
        return ResultData.success(this.cableService.selectCableById(cableId));
    }

    /**
     * 新增电缆
     *
     * @param cable
     * @return
     */
    @ApiOperation(value = "新增电缆")
    @PostMapping()
    public ResultData createCable(@RequestBody final CableDTO cable) {
        return ResultData.success(this.cableService.createCable(cable));
    }

    /**
     * 根据线路查询电缆
     *
     * @param trunklineId
     * @return
     */
    @ApiOperation(value = "根据线路查询电缆")
    @GetMapping("/selectByTrunkline/{trunklineId}")
    public ResultData selectByTrunkline(@ApiParam(name = "trunklineId", value = "0为所有线路", required = false) @PathVariable(value = "trunklineId", required = false) final Integer trunklineId) {
        return ResultData.success(this.cableService.selectByTrunklineId(trunklineId));
    }
}
