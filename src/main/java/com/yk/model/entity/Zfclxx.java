package com.yk.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 驻防车辆信息
 * </p>
 *
 * @author yangk
 * @since 2022-10-30
 */
@Getter
@Setter
@ApiModel(value = "Zfclxx对象", description = "驻防车辆信息")
public class Zfclxx {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String hh;

    private String cph;

    private String zhy;

    private String lxfs;

    private String yhh;

    private String cx;

    private String zfdw;

    private String zrxq;

    private String rs;

    private String bkq;

    private String gbid;

    private String imgUrl;


}
