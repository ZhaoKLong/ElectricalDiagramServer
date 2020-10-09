package com.electricaldiagram.controller.user;

import com.electricaldiagram.common.ResultData;
import com.electricaldiagram.entity.User;
import com.electricaldiagram.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("")
    public ResultData getUserList() {
        return ResultData.success(this.userService.selectAllUser());
    }

    /**
     * 新增用户
     */
    @ApiOperation(value = "新增用户")
    @PostMapping("/create")
    public ResultData createUser(@RequestBody final User user) {
        return ResultData.success(this.userService.createUser(user));
    }

    /**
     * 修改用户信息
     */
    @ApiOperation(value = "修改用户信息")
    @PutMapping("/update")
    public ResultData updateUser(@RequestBody final User user) {
        return ResultData.success(this.userService.updateUser(user));
    }
}
