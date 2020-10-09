package com.electricaldiagram.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.electricaldiagram.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
