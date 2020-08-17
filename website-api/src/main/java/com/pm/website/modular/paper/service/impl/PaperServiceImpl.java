package com.pm.website.modular.paper.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pm.common.bean.page.PageFactory;
import com.pm.common.bean.page.PageInfo;
import com.pm.common.bean.page.PageInfoHelper;
import com.pm.common.bean.page.PageQuery;
import com.pm.entity.paper.PaperEntity;
import com.pm.mapper.paper.PaperMapper;
import com.pm.model.website.ro.paper.PaperSearchCondition;
import com.pm.model.website.vo.paper.PaperPageVo;
import com.pm.website.modular.paper.service.IPaperService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 纸张表 服务实现类
 * </p>
 *
 * @author yejx
 * @since 2020-08-18
 */
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, PaperEntity> implements IPaperService {

    @Override
    public PageInfo<PaperPageVo> selectPageByCondition(PageQuery<PaperSearchCondition> pageQuery) {
        Page<PaperPageVo> page = PageFactory.createPage(pageQuery, true);
        IPage<PaperPageVo> pageResult = baseMapper.selectPageByCondition(page, pageQuery.getCondition());
        return PageInfoHelper.build(pageResult);
    }
}
