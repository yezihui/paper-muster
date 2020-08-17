package com.pm.entity.web;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 后台-用户表
 * </p>
 *
 * @author yejx
 * @since 2020-06-07
 */
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("t_web_user")
@ApiModel("后台-用户表")
public class WebUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", position = 1)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "登录名", position = 2)
    private String loginName;

    @ApiModelProperty(value = "昵称", position = 3)
    private String nickName;

    @ApiModelProperty(value = "密码", position = 4)
    private String password;

    @ApiModelProperty(value = "手机号码", position = 5)
    private String phone;

    @ApiModelProperty(value = "最后登录IP", position = 6)
    private String lastLoginIp;

    @ApiModelProperty(value = "最后登录时间", position = 7)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;

    @ApiModelProperty(value = "用户ca序列号", position = 6)
    private String userSn;

    @ApiModelProperty(value = "备注", position = 8)
    private String remark;

    @ApiModelProperty(value = "状态(0:禁用,1:启用)", position = 9)
    private Boolean isEnabled;

    @ApiModelProperty(value = "软删除标记(0:否,1:是)", position = 10)
    @TableLogic
    private Boolean isDelete;

    @ApiModelProperty(value = "创建用户ID", position = 11)
    private Long createUserId;

    @ApiModelProperty(value = "创建时间", position = 12)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "更新时间", position = 13)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
