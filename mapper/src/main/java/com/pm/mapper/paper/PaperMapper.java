package com.pm.mapper.paper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pm.entity.paper.PaperEntity;
import com.pm.model.website.ro.paper.PaperSearchCondition;
import com.pm.model.website.vo.paper.PaperPageVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 纸张表 Mapper 接口
 * </p>
 *
 * @author yejx
 * @since 2020-08-18
 */
public interface PaperMapper extends BaseMapper<PaperEntity> {

    IPage<PaperPageVo> selectPageByCondition(@Param("page") Page<PaperPageVo> page, @Param("condition") PaperSearchCondition condition);
}
