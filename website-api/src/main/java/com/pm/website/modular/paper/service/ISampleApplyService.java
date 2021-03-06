package com.pm.website.modular.paper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pm.common.bean.page.PageInfo;
import com.pm.common.bean.page.PageQuery;
import com.pm.entity.paper.PaperEntity;
import com.pm.entity.paper.SampleApplyEntity;
import com.pm.model.website.ro.paper.PaperSearchCondition;
import com.pm.model.website.ro.paper.SampleApplyRo;
import com.pm.model.website.vo.paper.PaperPageVo;

/**
 * <p>
 * 取样申请表 服务类
 * </p>
 *
 * @author yejx
 * @since 2020-08-18
 */
public interface ISampleApplyService extends IService<SampleApplyEntity> {

    void sampleApply(SampleApplyRo sampleApplyRo);
}
