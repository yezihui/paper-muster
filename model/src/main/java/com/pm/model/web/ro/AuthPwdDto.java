package com.pm.model.web.ro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 *
 * </p>
 *
 * @author Shawn Deng
 * @date 2019-04-15 18:34
 */
@Data
@ApiModel("修改安全密码参数")
public class AuthPwdDto {

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "旧密码", position = 1)
    private String oldPwd;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "新密码", position = 2)
    private String newPwd;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "重复新密码", position = 3)
    private String replyNewPwd;
}
