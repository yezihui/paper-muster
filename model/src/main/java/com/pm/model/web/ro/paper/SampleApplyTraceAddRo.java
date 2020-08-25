package com.pm.model.web.ro.paper;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Desc
 * @Author yejx
 * @Date 2020/8/18
 */
@Data
@ApiModel("抽样申请追踪轨迹Ro")
public class SampleApplyTraceAddRo {

    @NotNull
    @ApiModelProperty(value = "申请状态（0：新申请，1：已拒绝，2：已办理）", position = 3)
    private Integer status;

    @ApiModelProperty(value = "备注", position = 4)
    private String remark;
}
