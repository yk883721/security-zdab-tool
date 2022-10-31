package com.yk.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangk
 * @since 2022-10-30
 */
@Getter
@Setter
@ApiModel(value = "Ejldxfz对象", description = "")
public class Ejldxfz {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("支队")
    private String zd;

    @ApiModelProperty("辖区消防站")
    private String xqxfz;

    @ApiModelProperty("驻防点 ")
    private String zfd;

    @ApiModelProperty("呼号")
    private String hh;

    @ApiModelProperty("车型")
    private String cx;

    @ApiModelProperty("人数")
    private String rs;

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
