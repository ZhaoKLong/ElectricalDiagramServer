package com.electricaldiagram.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.electricaldiagram.dao.CableMapper;
import com.electricaldiagram.entity.Cable;
import com.electricaldiagram.service.CableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电缆表 服务实现类
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
@Service
public class CableServiceImpl extends ServiceImpl<CableMapper, Cable> implements CableService {

    @Autowired
    private CableMapper cableMapper;

    /**
     * 根据ID查询电缆
     *
     * @param cableId
     * @return
     */
    @Override
    public Cable selectCableById(Long cableId) {
        return this.cableMapper.selectById(cableId);
    }
}
