package com.pm.model.web.ro.paper;

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
@ApiModel("纸张新增Ro")
public class PaperAddRo {

    @NotBlank
    @ApiModelProperty(value = "纸种", position = 2)
    private String paperType;

    @NotBlank
    @ApiModelProperty(value = "产品编号", position = 4)
    private String paperNo;

    @NotBlank
    @ApiModelProperty(value = "产品名称", position = 4)
    private String paperName;

    @NotBlank
    @ApiModelProperty(value = "克重", position = 5)
    private String paperWeight;

    @NotBlank
    @ApiModelProperty(value = "产地", position = 6)
    private String paperOrigin;

    @NotBlank
    @ApiModelProperty(value = "耐破指数", position = 7)
    private String popStrength;

    @NotBlank
    @ApiModelProperty(value = "耐折强度", position = 3)
    private String foldStrength;

    @NotBlank
    @ApiModelProperty(value = "环压指数", position = 8)
    private String ringCrush;

    @NotBlank
    @ApiModelProperty(value = "水分", position = 9)
    private String moisture;

    @NotBlank
    @ApiModelProperty(value = "价格", position = 9)
    private String paperPrice;

    @ApiModelProperty(value = "起(是否最低价)", position = 10)
    private Boolean isBottom;

    @ApiModelProperty(value = "更新时间", position = 13)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
