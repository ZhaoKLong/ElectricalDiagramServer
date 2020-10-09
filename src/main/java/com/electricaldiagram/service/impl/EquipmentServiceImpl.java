package com.electricaldiagram.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.electricaldiagram.dao.EquipmentMapper;
import com.electricaldiagram.entity.Equipment;
import com.electricaldiagram.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment> implements EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * 根据ID查询设备
     *
     * @param equipmentId
     * @return
     */
    @Override
    public Equipment selectEquipmentById(Long equipmentId) {
        return this.equipmentMapper.selectById(equipmentId);
    }
}
