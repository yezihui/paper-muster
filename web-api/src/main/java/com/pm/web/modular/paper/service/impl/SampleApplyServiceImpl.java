package com.pm.web.modular.paper.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pm.common.bean.page.PageFactory;
import com.pm.common.bean.page.PageInfo;
import com.pm.common.bean.page.PageInfoHelper;
import com.pm.common.bean.page.PageQuery;
import com.pm.entity.paper.SampleApplyEntity;
import com.pm.entity.paper.SampleApplyTraceEntity;
import com.pm.mapper.paper.SampleApplyMapper;
import com.pm.mapper.paper.SampleApplyTraceMapper;
import com.pm.model.web.ro.paper.SampleApplySearchCondition;
import com.pm.model.web.ro.paper.SampleApplyTraceAddRo;
import com.pm.model.web.vo.paper.SampleApplyPageVo;
import com.pm.model.website.ro.paper.SampleApplyRo;
import com.pm.model.website.vo.paper.PaperPageVo;
import com.pm.web.bean.WebLoginUser;
import com.pm.web.context.LoginContext;
import com.pm.web.modular.paper.service.ISampleApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private SampleApplyTraceMapper sampleApplyTraceMapper;

    @Override
    public PageInfo<SampleApplyPageVo> sampleApplyPage(PageQuery<SampleApplySearchCondition> pageQuery) {
        Page<SampleApplyPageVo> page = PageFactory.createPage(pageQuery, true);
        IPage<SampleApplyPageVo> pageResult = baseMapper.selectPageByCondition(page, pageQuery.getCondition());
        return PageInfoHelper.build(pageResult);
    }

    @Override
    public List<SampleApplyTraceEntity> traceList(Long applyId) {
        return sampleApplyTraceMapper.selectList(new LambdaQueryWrapper<SampleApplyTraceEntity>()
                .eq(SampleApplyTraceEntity::getApplyId, applyId));
    }

    @Override
    public void addTrace(Long applyId, SampleApplyTraceAddRo traceAddRo) {
        WebLoginUser loginUser = LoginContext.me().getLoginUser();
        SampleApplyEntity update = new SampleApplyEntity();
        update.setId(applyId);
        update.setStatus(traceAddRo.getStatus());
        this.updateById(update);
        SampleApplyTraceEntity applyTrace = new SampleApplyTraceEntity();
        applyTrace.setStatus(traceAddRo.getStatus());
        applyTrace.setApplyId(applyId);
        applyTrace.setRemark(traceAddRo.getRemark());
        applyTrace.setCreateUserId(loginUser.getUserId());
        applyTrace.setCreateUserName(loginUser.getUserName());
        sampleApplyTraceMapper.insert(applyTrace);
    }

    @Override
    public void deleteTraceByIds(List<Long> ids) {
        sampleApplyTraceMapper.deleteBatchIds(ids);
    }
}
