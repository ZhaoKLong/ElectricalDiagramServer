package com.electricaldiagram.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.electricaldiagram.dao.TypeMapper;
import com.electricaldiagram.entity.Type;
import com.electricaldiagram.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 设备类型表 服务实现类
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    /**
     * 根据ID查询设备类型
     *
     * @param typeId
     * @return
     */
    @Override
    public Type selectTypeById(Long typeId) {
        return this.typeMapper.selectById(typeId);
    }
}
