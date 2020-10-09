package com.electricaldiagram.service;

import com.baomidou.mybatisplus.service.IService;
import com.electricaldiagram.entity.Trunkline;

/**
 * <p>
 * 线路表 服务类
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
public interface TrunklineService extends IService<Trunkline> {
    /**
     * 根据ID查询线路
     *
     * @param trunklineId
     * @return
     */
    Trunkline selectTrunklineById(Integer trunklineId);
}
