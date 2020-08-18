package com.pm.website.modular.paper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pm.entity.paper.SampleApplyEntity;
import com.pm.mapper.paper.SampleApplyMapper;
import com.pm.model.website.ro.paper.SampleApplyRo;
import com.pm.website.modular.paper.service.ISampleApplyService;
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
    public void sampleApply(SampleApplyRo sampleApplyRo) {
        SampleApplyEntity apply = new SampleApplyEntity();
        apply.setMessage(sampleApplyRo.getMessage());
        apply.setPhone(sampleApplyRo.getPhone());
        baseMapper.insert(apply);
    }
}
