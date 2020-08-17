package com.pm.model.web.ro.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author Shawn Deng
 * @date 2018/10/26 18:38
 */
@Data
@ApiModel("系统用户操作参数")
public class SystemUserRo {

    @ApiModelProperty(value = "用户名", position = 1)
    private String loginName;

    @ApiModelProperty(value = "昵称", position = 2)
    private String nickName;

    @ApiModelProperty(value = "性别(0:男,1:女)", position = 3)
    private String gender;

    @ApiModelProperty(value = "邮箱", position = 4)
    private String email;

    @ApiModelProperty(value = "备注", position = 5)
    private String remark;

    @ApiModelProperty(value = "状态(0:禁用,1:启用)", position = 6)
    private Boolean isEnabled;

    @ApiModelProperty(value = "手机号码", position = 7)
    @NotBlank
    private String mobilePhone;
}
