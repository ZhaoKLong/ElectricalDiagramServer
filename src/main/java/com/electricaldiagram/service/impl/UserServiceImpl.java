package com.electricaldiagram.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.electricaldiagram.dao.UserMapper;
import com.electricaldiagram.entity.User;
import com.electricaldiagram.service.UserService;
import com.electricaldiagram.util.SHA1orMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        user.setCreateTime(new Date());
        user.setModTime(new Date());
        user.setPassword(SHA1orMD5.md5(user.getPassword()));
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
        user.setModTime(new Date());
        if (null != user.getPassword()) {
            user.setPassword(SHA1orMD5.md5(user.getPassword()));
        }
        return this.userMapper.updateById(user);
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        user.setPassword(SHA1orMD5.md5(user.getPassword()));
        return this.userMapper.selectOne(user);
    }

    /**
     * 查询用户
     *
     * @param user
     * @return
     */
    @Override
    public User selectUserOne(User user) {
        return this.userMapper.selectOne(user);
    }
}
