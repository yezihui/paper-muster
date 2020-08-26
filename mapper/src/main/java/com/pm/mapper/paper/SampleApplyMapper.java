package com.pm.mapper.paper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pm.entity.paper.SampleApplyEntity;
import com.pm.model.web.ro.paper.SampleApplySearchCondition;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 取样申请表 Mapper 接口
 * </p>
 *
 * @author yejx
 * @since 2020-08-18
 */
public interface SampleApplyMapper extends BaseMapper<SampleApplyEntity> {

    IPage<SampleApplyEntity> selectPageByCondition(@Param("page") Page<SampleApplyEntity> page, @Param("condition") SampleApplySearchCondition condition);
}
