package com.electricaldiagram.controller.pole;

import com.electricaldiagram.common.ResultData;
import com.electricaldiagram.service.PoleService;
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
}
