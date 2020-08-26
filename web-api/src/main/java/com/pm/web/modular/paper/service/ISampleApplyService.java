package com.pm.web.modular.paper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pm.common.bean.page.PageInfo;
import com.pm.common.bean.page.PageQuery;
import com.pm.entity.paper.SampleApplyEntity;
import com.pm.entity.paper.SampleApplyTraceEntity;
import com.pm.model.web.ro.paper.SampleApplySearchCondition;
import com.pm.model.web.ro.paper.SampleApplyTraceAddRo;
import com.pm.model.website.ro.paper.SampleApplyRo;

import java.util.List;

/**
 * <p>
 * 取样申请表 服务类
 * </p>
 *
 * @author yejx
 * @since 2020-08-18
 */
public interface ISampleApplyService extends IService<SampleApplyEntity> {

    PageInfo<SampleApplyEntity> sampleApplyPage(PageQuery<SampleApplySearchCondition> pageQuery);

    List<SampleApplyTraceEntity> traceList(Long applyId);

    void addTrace(Long applyId, SampleApplyTraceAddRo traceAddRo);

    void deleteTraceByIds(List<Long> ids);
}
