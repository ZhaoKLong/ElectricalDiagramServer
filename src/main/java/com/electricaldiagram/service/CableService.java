package com.electricaldiagram.service;

import com.baomidou.mybatisplus.service.IService;
import com.electricaldiagram.entity.Cable;

/**
 * <p>
 * 电缆表 服务类
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
public interface CableService extends IService<Cable> {
    /**
     * 根据ID查询电缆
     *
     * @param cableId
     * @return
     */
    Cable selectCableById(Long cableId);
}
