package com.yk.model.dto.sdq_wxxfz;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SdqWxxfzSearchDto {

    private Integer page;

    private Integer size;

    @ApiModelProperty("微站名称")
    private String wzMc;

    @ApiModelProperty("地址")
    private String addr;

    @ApiModelProperty("负责人姓名")
    private String fzr;

}
