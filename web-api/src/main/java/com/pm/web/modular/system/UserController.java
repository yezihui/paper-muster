package com.pm.web.modular.system;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pm.common.bean.data.ResponseData;
import com.pm.common.bean.page.PageInfo;
import com.pm.common.bean.page.PageQuery;
import com.pm.model.web.ro.system.SystemUserRo;
import com.pm.model.web.ro.system.UpdateUserPwdRo;
import com.pm.model.web.ro.system.UserSearchCondition;
import com.pm.model.web.vo.system.SystemUserPageVo;
import com.pm.model.web.vo.system.SystemUserVo;
import com.pm.web.modular.system.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 系统用户接口
 * </p>
 *
 * @author Shawn Deng
 * @date 2018/10/25 15:04
 */
@Api(tags = "系统设置-用户管理接口")
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Resource
    private IUserService iUserService;

    @PostMapping(name = "查询用户列表", path = "/selectByPage")
    @ApiOperation(value = "分页查询用户", notes = "分页查询用户列表")
    public ResponseData<SystemUserPageVo> selectByPage(@RequestBody PageQuery<UserSearchCondition> page) {
        PageInfo<SystemUserPageVo> pageInfo = iUserService.selectByPage(page);
        return ResponseData.success(pageInfo);
    }

    @PostMapping(name = "新建用户", path = "/add")
    @ApiOperation(value = "新建用户", notes = "新建用户")
    public ResponseData add(@RequestBody @Valid SystemUserRo param) {
        iUserService.addUser(param);
        return ResponseData.success();
    }

    @GetMapping(name = "查询用户信息", path = "/select/{id}")
    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    public ResponseData<SystemUserVo> selectById(@PathVariable("id") Long userId) {
        SystemUserVo systemUser = iUserService.selectByUserId(userId);
        return ResponseData.success(systemUser);
    }

    @PostMapping(name = "编辑用户", path = "/edit/{id}")
    @ApiOperation(value = "编辑用户", notes = "编辑用户信息")
    public ResponseData editByUserId(@PathVariable("id") Long userId, @RequestBody @Valid SystemUserRo param) {
        iUserService.updateByUserId(userId, param);
        return ResponseData.success();
    }

    @PostMapping(name = "修改用户密码", path = "/update/pass/{userId}")
    @ApiOperation(value = "修改密码", notes = "修改密码")
    public ResponseData updatePass(@PathVariable("userId") Long userId, @RequestBody UpdateUserPwdRo updateUserPwdRo) {
        iUserService.updatePasswordByUserId(userId, updateUserPwdRo);
        return ResponseData.success();
    }

    @DeleteMapping(name = "删除用户", path = "/delete/{id}")
    @ApiOperation(value = "删除用户", notes = "删除用户以及用户关联角色")
    public ResponseData deleteByUserId(@PathVariable("id") Long id) {
        iUserService.deleteByUserId(id);
        return ResponseData.success();
    }
}
