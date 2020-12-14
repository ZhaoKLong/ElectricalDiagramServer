package com.electricaldiagram.controller.trunkline;

import com.electricaldiagram.common.ResultData;
import com.electricaldiagram.entity.Trunkline;
import com.electricaldiagram.service.TrunklineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: Zhaokl
 * @create: 2020-10-09 17:41
 **/
@Api(tags = "线路管理模块")
@RestController
@RequestMapping("/trunkline")
public class TrunklineController {
    @Autowired
    private TrunklineService trunklineService;

    /**
     * 根据ID查询线路
     *
     * @param trunklineId 线路ID
     * @return
     */
    @ApiOperation(value = "根据ID查询线路")
    @GetMapping("/{trunklineId}")
    public ResultData getTrunklineListByRole(@PathVariable(value = "trunklineId") final Integer trunklineId) {
        return ResultData.success(this.trunklineService.selectTrunklineById(trunklineId));
    }

    /**
     * 新增线路
     *
     * @param trunkline
     * @return
     */
    @ApiOperation(value = "新增线路")
    @PostMapping()
    public ResultData createTrunkline(@RequestBody final Trunkline trunkline) {
        return ResultData.success(this.trunklineService.createTrunkline(trunkline));
    }

    /**
     * 查询所有线路
     *
     * @return
     */
    @ApiOperation(value = "查询所有线路")
    @GetMapping("/all")
    public ResultData getAllTrunkline() {
        return ResultData.success(this.trunklineService.selectAll());
    }
}
