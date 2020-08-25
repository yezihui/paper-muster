package com.pm.entity.paper;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 取样申请跟踪表
 * </p>
 *
 * @author yejx
 * @since 2019-07-22 11:37
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@TableName("t_sample_apply_trace")
@ApiModel("取样申请跟踪表")
public class SampleApplyTraceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键id", position = 1)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "申请id", position = 2)
    private Long applyId;

    @ApiModelProperty(value = "申请状态（0：新申请，1：已拒绝，2：已办理）", position = 3)
    private Integer status;

    @ApiModelProperty(value = "备注", position = 4)
    private String remark;

    @ApiModelProperty(value = "创建用户ID", position = 5)
    private Long createUserId;

    @ApiModelProperty(value = "创建用户名", position = 6)
    private String createUserName;

    @ApiModelProperty(value = "创建时间", position = 7)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除标记(0:否,1:是)", position = 8)
    private Boolean isDelete;

}
