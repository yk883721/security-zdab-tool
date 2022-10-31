package com.yk.model.dto.ejldxfz;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EjldxfzUpdateDto {

    private Integer id;

    @ApiModelProperty("支队")
    private String zd;

    @ApiModelProperty("辖区消防站")
    private String xqxfz;

    @ApiModelProperty("负责人")
    private String fzr;

    @ApiModelProperty("部职别")
    private String bzb;

    @ApiModelProperty("手机")
    private String sj;

    @ApiModelProperty("战斗员")
    private String zdy;

    @ApiModelProperty("账号")
    private String zh;

}
