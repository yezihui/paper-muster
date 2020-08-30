package com.pm.model.web.vo.paper;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Desc
 * @Author yejx
 * @Date 2020/8/18
 */
@Data
@ApiModel("取样申请分页Vo")
public class SampleApplyPageVo {

    @ApiModelProperty(value = "主键", position = 1)
    private Long id;

    @ApiModelProperty(value = "纸种", position = 2)
    private String paperType;

    @ApiModelProperty(value = "产品编号", position = 4)
    private String paperNo;

    @ApiModelProperty(value = "产品名称", position = 4)
    private String paperName;

    @ApiModelProperty(value = "手机号", position = 14)
    private String phone;

    @ApiModelProperty(value = "取样申请信息", position = 14)
    private String message;

    @ApiModelProperty(value = "申请状态（0：新申请，1：已拒绝，2：已办理）", position = 3)
    private Integer status;

    @ApiModelProperty(value = "创建时间", position = 14)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
