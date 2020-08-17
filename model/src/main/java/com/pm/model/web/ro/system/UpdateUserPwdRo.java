package com.pm.model.web.ro.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/** 
* <p> 
* 修改密码请求参数
* </p> 
* @author Shawn Deng 
* @date 2019-04-10 10:35
*/ 
@Data
@ApiModel("修改用户密码参数")
public class UpdateUserPwdRo {

    @ApiModelProperty(value = "密码", position = 1)
    private String pwd;

    @ApiModelProperty(value = "重复密码", position = 1)
    private String replyPwd;
}
