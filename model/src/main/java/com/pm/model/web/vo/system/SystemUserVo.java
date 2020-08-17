package com.pm.model.web.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author Shawn Deng
 * @date 2018/10/26 18:38
 */
@Data
@Builder
@ApiModel("系统用户信息返回参数")
public class SystemUserVo {

    @ApiModelProperty(value = "用户ID", position = 1)
    private Long userId;

    @ApiModelProperty(value = "用户名", position = 1)
    private String loginName;

    @ApiModelProperty(value = "昵称", position = 3)
    private String nickName;

    @ApiModelProperty(value = "性别(0:男,1:女)", position = 2)
    private String gender;

    @ApiModelProperty(value = "邮箱", position = 3)
    private String email;

    @ApiModelProperty(value = "备注", position = 4)
    private String remark;

    @ApiModelProperty(value = "状态(0:禁用,1:启用)", position = 5)
    private Boolean isEnabled;

    @ApiModelProperty(value = "手机号码", position = 6)
    private String mobilePhone;

}
