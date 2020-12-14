package com.electricaldiagram.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.electricaldiagram.dto.PoleDTO;
import com.electricaldiagram.entity.Pole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 电杆表 Mapper 接口
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
@Repository
public interface PoleMapper extends BaseMapper<Pole> {
    /**
     * 根据线路查询电杆
     *
     * @param entityWrapper 线路Id
     * @return 线路列表
     */
    List<PoleDTO> selectListByTrunklineId(EntityWrapper entityWrapper);
}
