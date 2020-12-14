package com.electricaldiagram.controller.pole;

import com.electricaldiagram.common.ResultData;
import com.electricaldiagram.dto.PoleDTO;
import com.electricaldiagram.service.PoleService;
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
@Api(tags = "电杆管理模块")
@RestController
@RequestMapping("/pole")
public class PoleController {
    @Autowired
    private PoleService poleService;

    /**
     * 根据ID查询电杆
     *
     * @param poleId 电杆ID
     * @return
     */
    @ApiOperation(value = "根据ID查询电杆")
    @GetMapping("/{poleId}")
    public ResultData getPoleListByRole(@PathVariable(value = "poleId") final Long poleId) {
        return ResultData.success(this.poleService.selectPoleById(poleId));
    }

    /**
     * 新增电杆
     *
     * @param pole 电杆信息
     * @return
     */
    @ApiOperation(value = "新增电杆")
    @PostMapping()
    public ResultData createPole(@RequestBody final PoleDTO pole) {
        return ResultData.success(this.poleService.createPole(pole));
    }

    /**
     * 根据线路查询电杆
     *
     * @param trunklineId 线路Id
     * @return
     */
    @ApiOperation(value = "根据线路查询电杆")
    @GetMapping("/selectByTrunkline/{trunklineId}")
    public ResultData selectPole(@ApiParam(name = "trunklineId", value = "0为所有线路", required = false) @PathVariable(value = "trunklineId", required = false) final Integer trunklineId) {
        return ResultData.success(this.poleService.selectPoleByTrunklineId(trunklineId));
    }
}
