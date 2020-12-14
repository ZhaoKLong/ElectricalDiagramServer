package com.electricaldiagram.service;

import com.baomidou.mybatisplus.service.IService;
import com.electricaldiagram.dto.PoleDTO;
import com.electricaldiagram.entity.Pole;

import java.util.List;

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

    /**
     * 新增电杆
     *
     * @param pole
     * @return
     */
    Object createPole(PoleDTO pole);

    /**
     * 根据线路查询电杆
     *
     * @param trunklineId 线路Id
     * @return 线路列表
     */
    List<PoleDTO> selectPoleByTrunklineId(Integer trunklineId);
}
