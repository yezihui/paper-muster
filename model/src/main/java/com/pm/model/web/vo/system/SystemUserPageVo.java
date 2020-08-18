package com.pm.model.web.vo.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author Shawn Deng
 * @date 2018/10/26 14:21
 */
@Data
@ApiModel("系统用户分页信息")
public class SystemUserPageVo {

    @ApiModelProperty(value = "主键", position = 1)
    private Integer userId;

    @ApiModelProperty(value = "登录名", position = 1)
    private String loginName;

    @ApiModelProperty(value = "昵称", position = 3)
    private String nickName;

    @ApiModelProperty(value = "邮箱", position = 2)
    private String email;

    @ApiModelProperty(value = "状态(0:禁用,1:启用)", position = 4)
    private Boolean isEnabled;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", position = 5)
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "更新时间", position = 5)
    private Date updateTime;
}
