package com.pm.model.website.ro.paper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Desc
 * @Author yejx
 * @Date 2020/8/18
 */
@Data
@ApiModel("纸张搜索条件")
public class PaperSearchCondition {

    @ApiModelProperty(value = "产品名称", position = 4)
    private String paperName;

    @ApiModelProperty(value = "纸种", position = 4)
    private String paperType;

    @ApiModelProperty(value = "纸种值", position = 4)
    private Integer paperTypeValue;

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

    @JsonIgnore
    @ApiModelProperty(value = "是否后台查询", hidden = true)
    private Boolean isWeb;
}
