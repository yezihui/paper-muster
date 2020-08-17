package com.pm.model.web.ro.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>
 * 用户管理搜索条件
 * </p>
 *
 * @author Shawn Deng
 * @date 2018/10/26 14:21
 */
@Data
@ApiModel("用户管理搜索条件")
public class UserSearchCondition {

    @ApiModelProperty(value = "登录名", position = 1)
    private String loginName;

    @ApiModelProperty(value = "角色id(null或空值或-1：全部)", position = 3)
    private String roles;

    @ApiModelProperty(value = "状态(null或空值或-1:全部,0:禁用,1:启用)", position = 4)
    private Integer isEnabled;

    @ApiModelProperty(value = "注册时间开始", position = 5)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTimeBegin;

    @ApiModelProperty(value = "注册时间结束", position = 6)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTimeEnd;
}
