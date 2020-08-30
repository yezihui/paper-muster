package com.pm.model.website.ro.paper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Desc
 * @Author yejx
 * @Date 2020/8/18
 */
@Data
@ApiModel("取样申请Ro")
public class SampleApplyRo {

    @NotNull(message = "纸张ID不能为空")
    @ApiModelProperty(value = "纸张ID", position = 1)
    private Long paperId;

    @NotNull(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号", position = 1)
    private String phone;

    @ApiModelProperty(value = "申请信息", position = 2)
    private String message;
}
