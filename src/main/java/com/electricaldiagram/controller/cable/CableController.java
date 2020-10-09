package com.electricaldiagram.controller.cable;

import com.electricaldiagram.common.ResultData;
import com.electricaldiagram.service.CableService;
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
}
