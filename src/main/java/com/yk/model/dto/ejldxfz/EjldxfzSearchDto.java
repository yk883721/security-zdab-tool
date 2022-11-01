package com.yk.model.dto.ejldxfz;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EjldxfzSearchDto {

    private Integer page;

    private Integer size;

    @ApiModelProperty("辖区消防站")
    private String xqxfz;

    @ApiModelProperty("负责人")
    private String fzr;

    @ApiModelProperty("手机")
    private String sj;

}
