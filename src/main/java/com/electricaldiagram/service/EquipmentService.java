package com.electricaldiagram.service;

import com.baomidou.mybatisplus.service.IService;
import com.electricaldiagram.entity.Equipment;

import java.util.List;

/**
 * <p>
 * 设备表 服务类
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
public interface EquipmentService extends IService<Equipment> {
    /**
     * 根据ID查询设备
     *
     * @param equipmentId
     * @return
     */
    Equipment selectEquipmentById(Long equipmentId);

    /**
     * 根据线路查询设备
     *
     * @param trunklineId
     * @return
     */
    List selectEquipmentByTrunklineId(Integer trunklineId);
}
