package com.electricaldiagram.service;

import com.baomidou.mybatisplus.service.IService;
import com.electricaldiagram.entity.Pole;

/**
 * <p>
 * 电杆表 服务类
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
public interface PoleService extends IService<Pole> {
    /**
     * 根据ID查询电杆
     *
     * @param poleId
     * @return
     */
    Pole selectPoleById(Long poleId);
}
