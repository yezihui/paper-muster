package com.pm.web.modular.paper.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pm.common.bean.page.PageFactory;
import com.pm.common.bean.page.PageInfo;
import com.pm.common.bean.page.PageInfoHelper;
import com.pm.common.bean.page.PageQuery;
import com.pm.entity.paper.SampleApplyEntity;
import com.pm.mapper.paper.SampleApplyMapper;
import com.pm.model.website.ro.paper.SampleApplyRo;
import com.pm.model.website.vo.paper.PaperPageVo;
import com.pm.web.modular.paper.service.ISampleApplyService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 取样申请表 服务实现类
 * </p>
 *
 * @author yejx
 * @since 2020-08-18
 */
@Service
public class SampleApplyServiceImpl extends ServiceImpl<SampleApplyMapper, SampleApplyEntity> implements ISampleApplyService {

    @Override
    public PageInfo<SampleApplyEntity> sampleApplyPage(PageQuery pageQuery) {
        Page<SampleApplyEntity> page = PageFactory.createPage(pageQuery, true);
        IPage<SampleApplyEntity> pageResult = baseMapper.selectPageByCondition(page);
        return PageInfoHelper.build(pageResult);
    }
}
