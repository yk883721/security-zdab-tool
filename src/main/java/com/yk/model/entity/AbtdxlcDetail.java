package com.yk.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *  安保对象-巡逻车 - 平台补充数据信息
 * </p>
 */
@Getter
@Setter
@TableName("abtdxlc_detail")
@ApiModel(value = "AbtdxlcDetail", description = "安保对象-巡逻车 - 平台补充数据信息")
public class AbtdxlcDetail {

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

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;


}
