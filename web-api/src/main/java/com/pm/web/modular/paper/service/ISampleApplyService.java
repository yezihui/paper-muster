package com.pm.web.modular.paper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pm.common.bean.page.PageInfo;
import com.pm.common.bean.page.PageQuery;
import com.pm.entity.paper.SampleApplyEntity;
import com.pm.model.website.ro.paper.SampleApplyRo;

/**
 * <p>
 * 取样申请表 服务类
 * </p>
 *
 * @author yejx
 * @since 2020-08-18
 */
public interface ISampleApplyService extends IService<SampleApplyEntity> {

    PageInfo<SampleApplyEntity> sampleApplyPage(PageQuery pageQuery);
}
