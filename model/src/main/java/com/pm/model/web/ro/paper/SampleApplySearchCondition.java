package com.pm.model.web.ro.paper;

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
public class SampleApplySearchCondition {

    @ApiModelProperty(value = "手机号", position = 4)
    private String phone;

    @ApiModelProperty(value = "状态", position = 4)
    private Integer status;
}
