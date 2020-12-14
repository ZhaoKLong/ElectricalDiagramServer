package com.electricaldiagram.service;

import com.baomidou.mybatisplus.service.IService;
import com.electricaldiagram.entity.Type;

/**
 * <p>
 * 设备类型表 服务类
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
public interface TypeService extends IService<Type> {
    /**
     * 根据ID查询设备类型
     *
     * @param typeId
     * @return
     */
    Type selectTypeById(Long typeId);

    /**
     * 新增设备类型
     *
     * @param type
     * @return
     */
    Object createType(Type type);
}
