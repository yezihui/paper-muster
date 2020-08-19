package com.pm.mapper.web;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pm.entity.web.WebUserEntity;
import com.pm.model.web.ro.system.UserSearchCondition;
import com.pm.model.web.vo.system.SystemUserPageVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 后台-用户表 Mapper 接口
 * </p>
 *
 * @author yejx
 * @since 2020-06-07
 */
public interface WebUserMapper extends BaseMapper<WebUserEntity> {

    IPage<SystemUserPageVo> selectPageByUserId(@Param("page") Page<SystemUserPageVo> page, @Param("userId") Long currentUserId, @Param("condition") UserSearchCondition condition);
}
