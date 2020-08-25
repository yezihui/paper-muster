package com.pm.web.modular.paper.controller;

import com.pm.common.bean.data.ResponseData;
import com.pm.common.bean.page.PageInfo;
import com.pm.common.bean.page.PageQuery;
import com.pm.entity.paper.SampleApplyEntity;
import com.pm.model.web.ro.paper.PaperAddRo;
import com.pm.model.website.ro.paper.PaperSearchCondition;
import com.pm.model.website.ro.paper.SampleApplyRo;
import com.pm.model.website.vo.paper.PaperPageVo;
import com.pm.web.modular.paper.service.IPaperService;
import com.pm.web.modular.paper.service.ISampleApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Desc
 * @Author yejx
 * @Date 2020/8/18
 */
@Slf4j
@RestController
@RequestMapping("/paper")
@Api(tags = "纸张管理接口")
public class PaperController {

    @Resource
    private IPaperService iPaperService;

    @Resource
    private ISampleApplyService iSampleApplyService;

    @PostMapping(name = "分页查询纸张产品列表", path = "/page")
    @ApiOperation(value = "分页查询纸张产品列表")
    public ResponseData<PageInfo<PaperPageVo>> openPage(@Valid @RequestBody PageQuery<PaperSearchCondition> pageQuery) {
        PageInfo<PaperPageVo> pageInfo = iPaperService.selectPageByCondition(pageQuery);
        return ResponseData.success(pageInfo);
    }

    @PostMapping(name = "分页查询取样申请列表", path = "/sampleApply/page")
    @ApiOperation(value = "分页查询取样申请列表")
    public ResponseData<SampleApplyEntity> sampleApply(@Valid @RequestBody PageQuery pageQuery) {
        PageInfo<SampleApplyEntity> pageInfo = iSampleApplyService.sampleApplyPage(pageQuery);
        return ResponseData.success(pageInfo);
    }

    @PostMapping(name = "新增纸张", path = "/add")
    @ApiOperation(value = "新增纸张")
    public ResponseData add(@Valid @RequestBody PaperAddRo addRo) {
        iPaperService.add(addRo);
        return ResponseData.success();
    }

    @PostMapping(name = "编辑纸张", path = "/update/{id}")
    @ApiOperation(value = "编辑纸张")
    public ResponseData update(@PathVariable(value = "id") Long id, @Valid @RequestBody PaperAddRo addRo) {
        iPaperService.update(id, addRo);
        return ResponseData.success();
    }

    @DeleteMapping(name = "批量删除纸张", path = "/delete")
    @ApiOperation(value = "批量删除纸张", notes = "批量删除纸张")
    public ResponseData deleteByIds(@RequestBody List<Long> ids) {
        iPaperService.deleteByIds(ids);
        return ResponseData.success();
    }
}
