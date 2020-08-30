package com.pm.model.website.vo.paper;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Desc
 * @Author yejx
 * @Date 2020/8/18
 */
@Data
@ApiModel("纸张分页Vo")
public class PaperPageVo {

    @ApiModelProperty(value = "主键", position = 1)
    private Long id;

    @ApiModelProperty(value = "纸种", position = 2)
    private String paperType;

    @ApiModelProperty(value = "纸种英文", position = 2)
    private String paperTypeEnglish;

    @ApiModelProperty(value = "产品编号", position = 4)
    private String paperNo;

    @ApiModelProperty(value = "产品名称", position = 4)
    private String paperName;

    @ApiModelProperty(value = "产品名称英文", position = 4)
    private String paperNameEnglish;

    @ApiModelProperty(value = "克重", position = 5)
    private String paperWeight;

    @ApiModelProperty(value = "产地", position = 6)
    private String paperOrigin;

    @ApiModelProperty(value = "产地英文", position = 6)
    private String paperOriginEnglish;

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

    @ApiModelProperty(value = "创建时间", position = 14)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "更新时间", position = 15)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
