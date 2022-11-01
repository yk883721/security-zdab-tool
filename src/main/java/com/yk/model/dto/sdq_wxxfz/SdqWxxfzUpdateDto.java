package com.yk.model.dto.sdq_wxxfz;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SdqWxxfzUpdateDto {

    private Integer id;

    @ApiModelProperty("序号")
    private Integer sh;

    @ApiModelProperty("支队名称")
    private String zdMc;

    @ApiModelProperty("微站名称")
    private String wzMc;

    @ApiModelProperty("单位-性质")
    private String unit;

    @ApiModelProperty("地址")
    private String addr;

    @ApiModelProperty("固定电话")
    private String phone;

    @ApiModelProperty("负责人姓名")
    private String fzr;

    @ApiModelProperty("负责人电话")
    private String fzrPhone;

    @ApiModelProperty("微站可视化终端名称")
    private String wzkshzdmc;

    @ApiModelProperty("可视化对讲设备编号")
    private String kshdjsbbh;

    @ApiModelProperty("经度（百度坐标）")
    private String jd;

    @ApiModelProperty("纬度（百度坐标）")
    private String wd;

    @ApiModelProperty("是否配备电动车")
    private String sfpbddc;

    @ApiModelProperty("备注")
    private String bz;

    @ApiModelProperty("拉取视频需要的uid")
    private String uid;

    @ApiModelProperty("微站id")
    private String wzid;

    @ApiModelProperty("城地_经度")
    private String cdJd;

    @ApiModelProperty("城地_纬度")
    private String cdWd;

}
