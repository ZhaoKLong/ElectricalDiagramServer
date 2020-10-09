package com.electricaldiagram.controller.trunkline;

import com.electricaldiagram.common.ResultData;
import com.electricaldiagram.service.TrunklineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
}
