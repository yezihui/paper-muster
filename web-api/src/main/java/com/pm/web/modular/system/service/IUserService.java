package com.pm.web.modular.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pm.common.bean.page.PageInfo;
import com.pm.common.bean.page.PageQuery;
import com.pm.entity.web.WebUserEntity;
import com.pm.model.web.ro.system.SystemUserRo;
import com.pm.model.web.ro.system.UpdateUserPwdRo;
import com.pm.model.web.ro.system.UserSearchCondition;
import com.pm.model.web.vo.system.SystemUserPageVo;
import com.pm.model.web.vo.system.SystemUserVo;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Shawn Deng
 * @since 2018-10-25
 */
public interface IUserService extends IService<WebUserEntity> {

    /**
     * 根据用户名查询用户
     *
     * @param username 登录名
     * @return UserEntity
     * @author Shawn Deng
     * @date 2018/10/25 16:13
     */
    WebUserEntity selectByUsername(String username);

    /**
     * 根据手机号码查询用户
     *
     * @param mobilePhone 手机号码
     * @return UserEntity
     * @belong web
     * @author mozhiteng
     * @date 2020/2/18 12:05
     */
    WebUserEntity selectByMobilePhone(String mobilePhone);

    /**
     * 分页查询用户列表
     *
     * @param pageQuery 分页查询参数
     * @return PageInfo
     * @author Shawn Deng
     * @date 2018/10/26 15:28
     */
    PageInfo<SystemUserPageVo> selectByPage(PageQuery<UserSearchCondition> pageQuery);

    /**
     * 根据会员ID查询信息
     *
     * @param userId 用户ID
     * @return WebLoginUser
     * @author Shawn Deng
     * @date 2018/10/26 15:27
     */
    SystemUserVo selectByUserId(Long userId);

    /**
     * 新增用户
     *
     * @param systemUserRo 请求参数
     * @author Shawn Deng
     * @date 2018/10/27 17:10
     */
    void addUser(SystemUserRo systemUserRo);

    /**
     * 编辑用户
     *
     * @param userId       用户ID
     * @param systemUserRo 请求参数
     * @author Shawn Deng
     * @date 2018/10/27 17:10
     */
    void updateByUserId(Long userId, SystemUserRo systemUserRo);

    /**
     * 删除用户
     * 逻辑删除
     *
     * @param id 用户ID
     * @author Shawn Deng
     * @date 2018/10/27 17:10
     */
    void deleteByUserId(Long id);

    /**
     * 根据用户修改密码
     *
     * @param id              用户ID
     * @param updateUserPwdRo 请求参数
     * @author Shawn Deng
     * @date 2019-04-29 15:15
     */
    void updatePasswordByUserId(Long id, UpdateUserPwdRo updateUserPwdRo);

}
