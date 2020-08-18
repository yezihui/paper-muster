package com.pm.web.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 用户资源
 * </p>
 */
@Data
@Builder
@ApiModel("用户资源")
public class UserResource {

    @ApiModelProperty(value = "登录名", position = 1)
    private String username;

    @ApiModelProperty(value = "用户昵称", position = 2)
    private String nickName;

    @ApiModelProperty(value = "最后登录ip", position = 4)
    private String lastLoginIp;

    @ApiModelProperty(value = "备注", position = 5)
    private String remark;

    @ApiModelProperty(value = "最后登录时间", position = 6)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;

    @ApiModelProperty(value = "创建时间", position = 7)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
