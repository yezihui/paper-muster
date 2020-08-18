package com.pm.website.modular.paper.controller;

import com.pm.common.bean.data.ResponseData;
import com.pm.common.bean.page.PageInfo;
import com.pm.common.bean.page.PageQuery;
import com.pm.model.website.ro.paper.PaperSearchCondition;
import com.pm.model.website.ro.paper.SampleApplyRo;
import com.pm.model.website.vo.paper.PaperPageVo;
import com.pm.website.annotation.TokenValid;
import com.pm.website.modular.paper.service.IPaperService;
import com.pm.website.modular.paper.service.ISampleApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Desc
 * @Author yejx
 * @Date 2020/8/18
 */
@Slf4j
@RestController
@RequestMapping("/paper")
@Api(tags = "纸张接口")
public class PaperController {

    @Resource
    private IPaperService iPaperService;

    @Resource
    private ISampleApplyService iSampleApplyService;

    @PostMapping(name = "分页查询纸张产品列表", path = "/page")
    @ApiOperation(value = "分页查询纸张产品列表")
    @TokenValid(requireToken = false)
    public ResponseData<PageInfo<PaperPageVo>> openPage(@Valid @RequestBody PageQuery<PaperSearchCondition> pageQuery) {
        PageInfo<PaperPageVo> pageInfo = iPaperService.selectPageByCondition(pageQuery);
        return ResponseData.success(pageInfo);
    }

    @PostMapping(name = "取样申请接口", path = "/sampleApply")
    @ApiOperation(value = "取样申请接口")
    @TokenValid(requireToken = false)
    public ResponseData sampleApply(@Valid @RequestBody SampleApplyRo sampleApplyRo) {
        iSampleApplyService.sampleApply(sampleApplyRo);
        return ResponseData.success();
    }
}
