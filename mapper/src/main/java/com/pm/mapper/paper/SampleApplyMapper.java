package com.pm.mapper.paper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pm.entity.paper.SampleApplyEntity;

/**
 * <p>
 * 取样申请表 Mapper 接口
 * </p>
 *
 * @author yejx
 * @since 2020-08-18
 */
public interface SampleApplyMapper extends BaseMapper<SampleApplyEntity> {

    IPage<SampleApplyEntity> selectPageByCondition(Page<SampleApplyEntity> page);
}
