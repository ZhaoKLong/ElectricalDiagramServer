package com.electricaldiagram.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.electricaldiagram.entity.Cable;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 电缆表 Mapper 接口
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
@Repository
public interface CableMapper extends BaseMapper<Cable> {
}
