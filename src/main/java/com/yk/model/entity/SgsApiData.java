package com.yk.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 2022年和对讲信息表
 * </p>
 *
 * @author yangk
 * @since 2022-11-01
 */
@Getter
@Setter
@TableName("sgs_api_data")
@ApiModel(value = "SgsApiData对象", description = "2022年和对讲信息表")
public class SgsApiData {

    @ApiModelProperty("用户id(和对讲播放用的id)")
    private String userId;

    @ApiModelProperty("移动电话号码")
    private String mobilePhone;

    @ApiModelProperty("账号名")
    private String userName;

    @ApiModelProperty("持有者")
    private String displayName;

    private String iccid;

    @ApiModelProperty("设备id")
    private String deviceId;

    @ApiModelProperty("部门编号")
    private String departId;

    @ApiModelProperty("部门名称")
    private String departName;

    @ApiModelProperty("群组编号")
    private String companyId;

    @ApiModelProperty("群组编码")
    private String companyCode;

    @ApiModelProperty("结构信息")
    private String orgStructure;

    @ApiModelProperty("在线状态")
    private String presence;

    @ApiModelProperty("当前位置")
    private String addr;

    @ApiModelProperty("原始经度")
    private String lng;

    @ApiModelProperty("原始纬度")
    private String lat;

    @ApiModelProperty("城建x")
    private String cjX;

    @ApiModelProperty("城建y")
    private String cjY;

    private LocalDateTime insertTime;

    private LocalDateTime updateTime;


}
