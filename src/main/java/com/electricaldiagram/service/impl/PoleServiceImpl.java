package com.electricaldiagram.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.electricaldiagram.dao.EquipmentMapper;
import com.electricaldiagram.dao.PoleMapper;
import com.electricaldiagram.dao.TrunklineMapper;
import com.electricaldiagram.dto.PoleDTO;
import com.electricaldiagram.entity.Equipment;
import com.electricaldiagram.entity.Pole;
import com.electricaldiagram.entity.Trunkline;
import com.electricaldiagram.service.PoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private TrunklineMapper trunklineMapper;

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

    /**
     * 新增电杆
     *
     * @param poleVo
     * @return
     */
    @Override
    public Object createPole(PoleDTO poleVo) {
        Pole pole = new Pole();
        pole.setLatitude(poleVo.getLatitude());
        pole.setLongitude(poleVo.getLongitude());
        Pole pole1 = this.poleMapper.selectOne(pole);
        if (null != pole1.getPoleId()) {
            return 0;
        } else {
            pole.setName(poleVo.getName());
            pole.setPhotosUrl(poleVo.getPhotosUrl());
            pole.setRemark(poleVo.getRemark());
            pole.setTrunklineId(poleVo.getTrunklineId());
            pole.setCreateTime(new Date());
            pole.setModTime(new Date());
            int insertRow = this.poleMapper.insert(pole);
            if (insertRow == 1) {
                Pole insertPole = this.poleMapper.selectOne(pole);
                List<Equipment> equipmentList = poleVo.getEquipmentList();
                int insertNum = 0;
                for (Equipment equipment : equipmentList) {
                    equipment.setPoleId(insertPole.getPoleId());
                    equipment.setTrunklineId(poleVo.getTrunklineId());
                    equipment.setCreateTime(new Date());
                    equipment.setModTime(new Date());
                    insertNum += this.equipmentMapper.insert(equipment);
                }
                if (insertNum == equipmentList.size()) {
                    return insertPole.getPoleId();
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }

    /**
     * 根据线路查询电杆
     *
     * @param trunklineId 线路Id
     * @return 线路列表
     */
    @Override
    public List<PoleDTO> selectPoleByTrunklineId(Integer trunklineId) {
        Pole pole = new Pole();
        pole.setTrunklineId(trunklineId);
        EntityWrapper entityWrapper = new EntityWrapper();
        if (trunklineId == 0) {
            entityWrapper = null;
        } else {
            entityWrapper.setEntity(pole);
        }
        List<Pole> list = this.poleMapper.selectList(entityWrapper);
        List<PoleDTO> listDto = new ArrayList<>();
        for (Pole item : list) {
            PoleDTO poleDTO = new PoleDTO();
            Long poleId = item.getPoleId();
            EntityWrapper entityWrapperPole = new EntityWrapper();
            Equipment equipment = new Equipment();
            equipment.setPoleId(poleId);
            entityWrapperPole.setEntity(equipment);
            List<Equipment> list1 = this.equipmentMapper.selectList(entityWrapperPole);
            poleDTO.setLatitude(item.getLatitude());
            poleDTO.setLongitude(item.getLongitude());
            poleDTO.setName(item.getName());
            poleDTO.setPhotosUrl(item.getPhotosUrl());
            poleDTO.setPoleId(item.getPoleId());
            poleDTO.setRemark(item.getRemark());
            poleDTO.setTrunklineId(item.getTrunklineId());
            poleDTO.setIsFactory(item.getIsFactory());
            Trunkline trunkline = new Trunkline();
            trunkline.setTrunklineId(item.getTrunklineId());
            poleDTO.setTrunklineName(this.trunklineMapper.selectOne(trunkline).getName());
            poleDTO.setEquipmentList(list1);
            listDto.add(poleDTO);
        }
        return listDto;
    }
}
