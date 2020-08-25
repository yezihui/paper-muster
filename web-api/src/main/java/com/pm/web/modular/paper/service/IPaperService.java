package com.pm.web.modular.paper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pm.common.bean.page.PageInfo;
import com.pm.common.bean.page.PageQuery;
import com.pm.entity.paper.PaperEntity;
import com.pm.model.web.ro.paper.PaperAddRo;
import com.pm.model.website.ro.paper.PaperSearchCondition;
import com.pm.model.website.vo.paper.PaperPageVo;

import java.util.List;

/**
 * <p>
 * 纸张表 服务类
 * </p>
 *
 * @author yejx
 * @since 2020-08-18
 */
public interface IPaperService extends IService<PaperEntity> {

    PageInfo<PaperPageVo> selectPageByCondition(PageQuery<PaperSearchCondition> pageQuery);

    void add(PaperAddRo addRo);

    void deleteByIds(List<Long> ids);

    void update(Long id, PaperAddRo addRo);
}
