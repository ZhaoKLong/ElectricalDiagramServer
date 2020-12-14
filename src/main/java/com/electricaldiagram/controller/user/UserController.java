package com.electricaldiagram.controller.user;

import com.electricaldiagram.common.ErrorCode;
import com.electricaldiagram.common.ResultData;
import com.electricaldiagram.entity.User;
import com.electricaldiagram.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 * @description:
 * @author: Zhaokl
 * @create: 2020-10-09 17:39
 **/
@Api(tags = "用户管理模块")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据ID查询用户
     *
     * @param userId 用户ID
     * @return
     */
    @ApiOperation(value = "根据ID查询用户")
    @GetMapping("/{userId}")
    public ResultData getUserListByRole(@PathVariable(value = "userId") final Long userId) {
        return ResultData.success(this.userService.selectUserById(userId));
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @ApiOperation(value = "查询所有用户")
    @GetMapping("/all")
    public ResultData getUserList() {
        return ResultData.success(this.userService.selectAllUser());
    }

    /**
     * 新增用户
     */
    @ApiOperation(value = "新增用户")
    @PostMapping()
    public ResultData createUser(@RequestBody final User user) {
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1 = this.userService.selectUserOne(user1);
        if (null != user1) {
            return ResultData.error(ErrorCode.DEFAULT_ERROR, "重复的用户名");
        } else {
            return ResultData.success(this.userService.createUser(user));
        }
    }

    /**
     * 修改用户信息
     */
    @ApiOperation(value = "修改用户信息")
    @PutMapping()
    public ResultData updateUser(@RequestBody User user) {
        user.setModTime(new Date());
        return ResultData.success(this.userService.updateUser(user));
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public ResultData login(@RequestBody final User user) {
        if (null == user) {
            return ResultData.error(ErrorCode.PERSISTENT_DATA_ERROR, "请输入账号或密码");
        }
        final User loginUser;
        loginUser = userService.login(user);
        if (null == loginUser) {
            return ResultData.error(ErrorCode.PASSWORD_ERROR, "账户或密码错误!");
        } else {
            return ResultData.success(loginUser);
        }
    }
}
