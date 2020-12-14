package com.electricaldiagram.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.electricaldiagram.dao.CableMapper;
import com.electricaldiagram.dao.PoleMapper;
import com.electricaldiagram.dto.CableDTO;
import com.electricaldiagram.entity.Cable;
import com.electricaldiagram.entity.Pole;
import com.electricaldiagram.service.CableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private PoleMapper poleMapper;

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

    /**
     * 新增电缆
     *
     * @param cableDto
     * @return
     */
    @Override
    public Object createCable(CableDTO cableDto) {
        Cable cable = new Cable();
        Pole prePole = cableDto.getPrev();
        Pole nextPole = cableDto.getNext();
        Pole searchPole = new Pole();
        searchPole.setLongitude(prePole.getLongitude());
        searchPole.setLatitude(prePole.getLatitude());
        prePole = this.poleMapper.selectOne(searchPole);
        if (null == prePole) {
            return 0;
        } else {
            cable.setPrePoleId(prePole.getPoleId());
            searchPole.setLongitude(nextPole.getLongitude());
            searchPole.setLatitude(nextPole.getLatitude());
            nextPole = this.poleMapper.selectOne(searchPole);
            if (null == nextPole) {
                return 0;
            } else {
                cable.setNextPoleId(nextPole.getPoleId());
                cable.setName(cableDto.getName());
                cable.setLength(cableDto.getLength());
                cable.setType(cableDto.getType());
                cable.setRemark(cableDto.getRemark());
                cable.setTrunklineId(cableDto.getTrunklineId());
                cable.setCreateTime(new Date());
                cable.setModTime(new Date());
                return this.cableMapper.insert(cable);
            }
        }
    }

    /**
     * 根据线路查询电缆
     *
     * @param trunklineId
     * @return
     */
    @Override
    public List<CableDTO> selectByTrunklineId(Integer trunklineId) {
        Cable cable = new Cable();
        cable.setTrunklineId(trunklineId);
        EntityWrapper entityWrapper = new EntityWrapper();
        if (trunklineId == 0) {
            entityWrapper = null;
        } else {
            entityWrapper.setEntity(cable);
        }
        List<Cable> list = this.cableMapper.selectList(entityWrapper);
        List<CableDTO> cableDTOList = new ArrayList<>();
        for (Cable item : list) {
            CableDTO newCable = new CableDTO();
            newCable.setCableId(item.getCableId());
            newCable.setLength(item.getLength());
            newCable.setName(item.getName());
            newCable.setRemark(item.getRemark());
            newCable.setTrunklineId(item.getTrunklineId());
            newCable.setType(item.getType());
            newCable.setIsMain(item.getIsMain());
            Pole pole = new Pole();
            pole.setPoleId(item.getPrePoleId());
            newCable.setPrev(this.poleMapper.selectOne(pole));
            pole.setPoleId(item.getNextPoleId());
            newCable.setNext(this.poleMapper.selectOne(pole));
            cableDTOList.add(newCable);
        }
        return cableDTOList;
    }
}
