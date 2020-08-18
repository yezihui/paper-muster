package com.pm.web.modular.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pm.common.bean.page.PageFactory;
import com.pm.common.bean.page.PageInfo;
import com.pm.common.bean.page.PageInfoHelper;
import com.pm.common.bean.page.PageQuery;
import com.pm.common.util.ExceptionUtil;
import com.pm.entity.web.WebUserEntity;
import com.pm.mapper.web.WebUserMapper;
import com.pm.model.web.ro.system.SystemUserRo;
import com.pm.model.web.ro.system.UpdateUserPwdRo;
import com.pm.model.web.ro.system.UserSearchCondition;
import com.pm.model.web.vo.system.SystemUserPageVo;
import com.pm.model.web.vo.system.SystemUserVo;
import com.pm.web.bean.WebLoginUser;
import com.pm.web.context.LoginContext;
import com.pm.web.exception.SystemExceptionEnum;
import com.pm.web.modular.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Shawn Deng
 * @since 2018-10-25
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<WebUserMapper, WebUserEntity> implements IUserService {


    /**
     * 密钥加密工具
     */
    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    @SuppressWarnings("unchecked")
    public WebUserEntity selectByUsername(String username) {
        log.info("根据用户名【{}】查询", username);
        return getOne(new LambdaQueryWrapper<WebUserEntity>()
                .eq(WebUserEntity::getLoginName, username));
    }

    @Override
    public WebUserEntity selectByMobilePhone(String mobilePhone) {
        log.info("根据手机号码【{}】查询", mobilePhone);
        return getOne(new LambdaQueryWrapper<WebUserEntity>()
                .eq(WebUserEntity::getPhone, mobilePhone));
    }

    @Override
    public PageInfo<SystemUserPageVo> selectByPage(PageQuery<UserSearchCondition> pageQuery) {
        log.info("分页查询用户列表");
        WebLoginUser webLoginUser = LoginContext.me().getLoginUser();
        Long currentUserId = webLoginUser.getUserId();
        Page<SystemUserPageVo> page = PageFactory.createPage(pageQuery, true);
        UserSearchCondition condition = pageQuery.getCondition();
        IPage<SystemUserPageVo> pageResult = baseMapper.selectPageByUserId(page, currentUserId, condition);
        return PageInfoHelper.build(pageResult);
    }

    @Override
    public SystemUserVo selectByUserId(Long userId) {
        log.info("查询用户信息");
        WebUserEntity user = getById(userId);
        //判断用户名是否存在
        ExceptionUtil.isNotNull(user, SystemExceptionEnum.SYSTEM_USER_NAME_EXIST);
        return SystemUserVo.builder().userId(user.getId()).loginName(user.getLoginName())
                .nickName(user.getNickName())
                .isEnabled(user.getIsEnabled())
                .mobilePhone(user.getPhone())
                .remark(user.getRemark()).build();
    }

    @Override
    public void addUser(SystemUserRo systemUserRo) {
        log.info("新增用户");
        WebLoginUser webLoginUser = LoginContext.me().getLoginUser();
        WebUserEntity user = selectByUsername(systemUserRo.getLoginName());
        //判断用户名是否存在
        ExceptionUtil.isNull(user, SystemExceptionEnum.SYSTEM_USER_NAME_EXIST);

        String mobilePhone = systemUserRo.getMobilePhone();
        if (StrUtil.isNotEmpty(mobilePhone)) {
            WebUserEntity userEntity = selectByMobilePhone(mobilePhone);
            //判断手机号码是否被绑定了
            ExceptionUtil.isNull(userEntity, SystemExceptionEnum.SYSTEM_USER_PHONE_EXIST);
        }

        WebUserEntity entity = WebUserEntity.builder()
                .loginName(systemUserRo.getLoginName())
                .nickName(systemUserRo.getNickName())
                .password(passwordEncoder.encode(systemUserRo.getLoginName()))
                .remark(systemUserRo.getRemark())
                .isEnabled(systemUserRo.getIsEnabled())
                .phone(systemUserRo.getMobilePhone())
                .createUserId(webLoginUser.getUserId())
                .build();

        boolean flag = save(entity);
        ExceptionUtil.isTrue(flag, SystemExceptionEnum.ADD_FAIL);
    }

    @Override
    public void updateByUserId(Long userId, SystemUserRo systemUserRo) {
        log.info("编辑用户");

        String mobilePhone = systemUserRo.getMobilePhone();
        WebUserEntity oldCurrentUser = getById(userId);
        //如果该用户手机号码被修改了，则就校验手机号码是否被绑定了
        if (!mobilePhone.equals(oldCurrentUser.getPhone())) {
            WebUserEntity newCurrentUser = selectByMobilePhone(mobilePhone);
            //判断手机号码是否被绑定了
            ExceptionUtil.isFalse(null != newCurrentUser && !userId.equals(newCurrentUser.getId()), SystemExceptionEnum.SYSTEM_USER_PHONE_EXIST);
        }

        WebUserEntity entity = WebUserEntity.builder()
                .id(userId).nickName(systemUserRo.getNickName())
                .remark(systemUserRo.getRemark())
                .phone(systemUserRo.getMobilePhone())
                .isEnabled(systemUserRo.getIsEnabled()).build();
        entity.setUpdateTime(new Date());
        boolean flag = updateById(entity);
        ExceptionUtil.isTrue(flag, SystemExceptionEnum.EDIT_FAIL);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByUserId(Long id) {
        log.info("删除用户,逻辑删除");
        boolean flag = removeById(id);
        ExceptionUtil.isTrue(flag, SystemExceptionEnum.REMOVE_FAIL);
        // 将所有用户用户下线
        LoginContext.me().getLoginUserService().removeByLoginUserId(id);
    }

    @Override
    public void updatePasswordByUserId(Long id, UpdateUserPwdRo updateUserPwdRo) {
        WebUserEntity user = getById(id);
        ExceptionUtil.isNotNull(user, SystemExceptionEnum.SYSTEM_USER_NOT_EXIST);
        WebUserEntity entity = WebUserEntity.builder()
                .id(id)
                .loginName(user.getLoginName())
                .password(passwordEncoder.encode(updateUserPwdRo.getPwd())).build();
        boolean flag = updateById(entity);
        ExceptionUtil.isTrue(flag, SystemExceptionEnum.RESET_USER_FAIL);
        // 将其用户下线
        LoginContext.me().getLoginUserService().removeByLoginUserId(id);
    }


}
