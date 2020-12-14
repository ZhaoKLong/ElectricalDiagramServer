package com.electricaldiagram.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.electricaldiagram.dao.TrunklineMapper;
import com.electricaldiagram.entity.Trunkline;
import com.electricaldiagram.service.TrunklineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 线路表 服务实现类
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
@Service
public class TrunklineServiceImpl extends ServiceImpl<TrunklineMapper, Trunkline> implements TrunklineService {

    @Autowired
    private TrunklineMapper trunklineMapper;

    /**
     * 根据ID查询线路
     *
     * @param trunklineId
     * @return
     */
    @Override
    public Trunkline selectTrunklineById(Integer trunklineId) {
        return this.trunklineMapper.selectById(trunklineId);
    }

    /**
     * 新增线路
     *
     * @param trunkline
     * @return
     */
    @Override
    public Object createTrunkline(Trunkline trunkline) {
        trunkline.setCreateTime(new Date());
        trunkline.setModTime(new Date());
        return this.trunklineMapper.insert(trunkline);
    }

    /**
     * 查询所有线路
     *
     * @return
     */
    @Override
    public List<Trunkline> selectAll() {
        return this.trunklineMapper.selectList(null);
    }
}
