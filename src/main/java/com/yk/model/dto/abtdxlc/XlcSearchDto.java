package com.yk.model.dto.abtdxlc;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class XlcSearchDto {

    private Integer page;

    private Integer size;

    @ApiModelProperty("名称")
    private String mc;

    @ApiModelProperty("区域")
    private String qy;

    @ApiModelProperty("车辆代号")
    private String cldh;

}
