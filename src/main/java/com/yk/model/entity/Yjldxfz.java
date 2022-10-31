package com.yk.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 一级流动消防站
 * </p>
 *
 * @author yangk
 * @since 2022-10-28
 */
@Getter
@Setter
@ApiModel(value = "Yjldxfz对象", description = "一级流动消防站")
public class Yjldxfz {

    @ApiModelProperty(" ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("支队")
    private String zd;

    @ApiModelProperty("辖区消防站")
    private String xqxfz;

    @ApiModelProperty("驻防点 ")
    private String zfd;

    @ApiModelProperty("驻防车辆（呼号）")
    private String zfcl;

    @ApiModelProperty("车型")
    private String cx;

    @ApiModelProperty("人数")
    private String rx;

    @ApiModelProperty("跟车指挥")
    private String gczh;

    @ApiModelProperty("部职别")
    private String bzb;

    @ApiModelProperty("手机")
    private String sj;

    @ApiModelProperty("驾驶员")
    private String jsy;

    @ApiModelProperty("通信员")
    private String txy;

    @ApiModelProperty("战斗员")
    private String zdy;

    @ApiModelProperty("布控球名称")
    private String bkqmc;

    @ApiModelProperty("布控球ID")
    private String bkqid;

}
