package com.electricaldiagram.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.electricaldiagram.dao.UserMapper;
import com.electricaldiagram.entity.User;
import com.electricaldiagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @Author Zkl
 * @Date 2020-10-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据ID查询用户
     *
     * @param userId
     * @return
     */
    @Override
    public User selectUserById(Long userId) {
        return this.userMapper.selectById(userId);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> selectAllUser() {
        return this.userMapper.selectList(null);
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @Override
    public Object createUser(User user) {
        return this.userMapper.insert(user);
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Override
    public Integer updateUser(User user) {
        return this.userMapper.updateById(user);
    }
}
