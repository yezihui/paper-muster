package com.pm.model.website.vo.paper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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

    @ApiModelProperty(value = "产品编号", position = 3)
    private String paperNo;

    @ApiModelProperty(value = "产品名称", position = 4)
    private String paperName;

    @ApiModelProperty(value = "克重", position = 5)
    private String paperWeight;

    @ApiModelProperty(value = "产地", position = 6)
    private String paperOrigin;

    @ApiModelProperty(value = "耐破指数", position = 7)
    private String popStrength;

    @ApiModelProperty(value = "环压指数", position = 8)
    private String ringCrush;

    @ApiModelProperty(value = "价格", position = 9)
    private String paperPrice;
}
