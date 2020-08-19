package com.pm.entity.paper;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
 * 纸张表
 * </p>
 *
 * @author yejx
 * @since 2020-08-18
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@TableName("t_paper")
@ApiModel("纸张表")
public class PaperEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", position = 1)
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "纸种", position = 2)
    private String paperType;

    @ApiModelProperty(value = "产品名称", position = 4)
    private String paperName;

    @ApiModelProperty(value = "克重", position = 5)
    private String paperWeight;

    @ApiModelProperty(value = "产地", position = 6)
    private String paperOrigin;

    @ApiModelProperty(value = "耐破指数", position = 7)
    private String popStrength;

    @ApiModelProperty(value = "耐折强度", position = 3)
    private String foldStrength;

    @ApiModelProperty(value = "环压指数", position = 8)
    private String ringCrush;

    @ApiModelProperty(value = "水分", position = 9)
    private String moisture;

    @ApiModelProperty(value = "价格", position = 9)
    private String paperPrice;

    @ApiModelProperty(value = "起(是否最低价)", position = 10)
    private Boolean isBottom;

    @ApiModelProperty(value = "状态(0:禁用,1:启用)", position = 10)
    private Boolean isEnabled;

    @ApiModelProperty(value = "软删除标记(0:否,1:是)", position = 11)
    @TableLogic
    private Boolean isDelete;

    @ApiModelProperty(value = "创建用户ID", position = 12)
    private Long createUserId;

    @ApiModelProperty(value = "修改用户ID", position = 13)
    private Long updateUserId;

    @ApiModelProperty(value = "创建时间", position = 14)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "更新时间", position = 15)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
