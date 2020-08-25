package com.pm.web.modular.paper.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pm.common.bean.page.PageFactory;
import com.pm.common.bean.page.PageInfo;
import com.pm.common.bean.page.PageInfoHelper;
import com.pm.common.bean.page.PageQuery;
import com.pm.entity.paper.PaperEntity;
import com.pm.mapper.paper.PaperMapper;
import com.pm.model.web.ro.paper.PaperAddRo;
import com.pm.model.website.ro.paper.PaperSearchCondition;
import com.pm.model.website.vo.paper.PaperPageVo;
import com.pm.web.bean.WebLoginUser;
import com.pm.web.context.LoginContext;
import com.pm.web.modular.paper.service.IPaperService;
import org.springframework.stereotype.Service;

import java.util.List;

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
//        PaperSearchCondition condition = pageQuery.getCondition();
//        if (ObjectUtil.isNull(pageQuery.getCondition())) {
//            condition = new PaperSearchCondition();
//        }
//        condition.setIsWeb(true);
        Page<PaperPageVo> page = PageFactory.createPage(pageQuery, true);
        IPage<PaperPageVo> pageResult = baseMapper.selectPageByCondition(page, pageQuery.getCondition());
        return PageInfoHelper.build(pageResult);
    }

    @Override
    public void add(PaperAddRo addRo) {
        PaperEntity paperEntity = new PaperEntity();
        BeanUtil.copyProperties(addRo, paperEntity);
        WebLoginUser loginUser = LoginContext.me().getLoginUser();
        paperEntity.setCreateUserId(loginUser.getUserId());
        if (ObjectUtil.isNull(paperEntity.getUpdateTime())) {
            paperEntity.setUpdateTime(DateUtil.date());
        }
        baseMapper.insert(paperEntity);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        removeByIds(ids);
    }

    @Override
    public void update(Long id, PaperAddRo addRo) {
        PaperEntity paperEntity = new PaperEntity();
        BeanUtil.copyProperties(addRo, paperEntity);
        WebLoginUser loginUser = LoginContext.me().getLoginUser();
        paperEntity.setCreateUserId(loginUser.getUserId());
        if (ObjectUtil.isNull(paperEntity.getUpdateTime())) {
            paperEntity.setUpdateTime(DateUtil.date());
        }
        baseMapper.insert(paperEntity);
    }
}
