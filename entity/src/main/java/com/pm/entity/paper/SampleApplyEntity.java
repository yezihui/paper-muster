package com.pm.entity.paper;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 取样申请表
 * </p>
 *
 * @author yejx
 * @since 2020-08-18
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@TableName("t_sample_apply")
@ApiModel("取样申请表")
public class SampleApplyEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", position = 1)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "手机号", position = 14)
    private String phone;

    @ApiModelProperty(value = "取样申请信息", position = 14)
    private String message;

    @ApiModelProperty(value = "创建时间", position = 14)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


}
