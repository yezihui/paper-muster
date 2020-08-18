package com.pm.model.web.ro.paper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

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
    @ApiModelProperty(value = "产品编号", position = 3)
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
    @ApiModelProperty(value = "环压指数", position = 8)
    private String ringCrush;

    @NotBlank
    @ApiModelProperty(value = "价格", position = 9)
    private String paperPrice;
}
