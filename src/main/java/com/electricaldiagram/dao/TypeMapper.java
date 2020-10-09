package com.electricaldiagram.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.electricaldiagram.entity.Type;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 设备类型表 Mapper 接口
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
@Repository
public interface TypeMapper extends BaseMapper<Type> {
}
