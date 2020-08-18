package com.pm.model.website.ro.paper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Desc
 * @Author yejx
 * @Date 2020/8/18
 */
@Data
@ApiModel("纸张搜索条件")
public class PaperSearchCondition {

    @ApiModelProperty(value = "产品名称", position = 4)
    private String paperName;

    @JsonIgnore
    @ApiModelProperty(value = "是否后台查询", hidden = true)
    private Boolean isWeb;
}
