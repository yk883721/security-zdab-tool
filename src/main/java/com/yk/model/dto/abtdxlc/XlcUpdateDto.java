package com.yk.model.dto.abtdxlc;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class XlcUpdateDto {

    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("姓名")
    private String mc;

    @ApiModelProperty("联系方式")
    private String lxfs;

    @ApiModelProperty("区域")
    private String qy;

    @ApiModelProperty("车辆代号")
    private String cldh;

    @ApiModelProperty("和对讲账号")
    private String zh;

    @ApiModelProperty("UID")
    private String uid;

    @ApiModelProperty("经度")
    private String jd;

    @ApiModelProperty("纬度")
    private String wd;

    @ApiModelProperty("城地_经度")
    private String cdJd;

    @ApiModelProperty("城地_纬度")
    private String cdWd;

}
