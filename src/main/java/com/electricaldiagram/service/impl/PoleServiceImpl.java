package com.electricaldiagram.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.electricaldiagram.dao.PoleMapper;
import com.electricaldiagram.entity.Pole;
import com.electricaldiagram.service.PoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 电杆表 服务实现类
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
@Service
public class PoleServiceImpl extends ServiceImpl<PoleMapper, Pole> implements PoleService {

    @Autowired
    private PoleMapper poleMapper;

    /**
     * 根据ID查询电杆
     *
     * @param poleId
     * @return
     */
    @Override
    public Pole selectPoleById(Long poleId) {
        return this.poleMapper.selectById(poleId);
    }
}
