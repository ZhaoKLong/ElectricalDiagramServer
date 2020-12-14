package com.electricaldiagram.service;

import com.baomidou.mybatisplus.service.IService;
import com.electricaldiagram.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
public interface UserService extends IService<User> {
    /**
     * 根据ID查询用户
     *
     * @param userId
     * @return
     */
    User selectUserById(Long userId);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> selectAllUser();

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    Object createUser(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 查询用户
     *
     * @param user
     * @return
     */
    User selectUserOne(User user);
}
