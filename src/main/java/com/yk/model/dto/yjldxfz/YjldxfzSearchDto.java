package com.yk.model.dto.yjldxfz;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class YjldxfzSearchDto {

    private Integer page;

    private Integer size;

    @ApiModelProperty("呼号")
    private String zfcl;

    @ApiModelProperty("手机")
    private String sj;

    @ApiModelProperty("跟车指挥")
    private String gczh;

}
