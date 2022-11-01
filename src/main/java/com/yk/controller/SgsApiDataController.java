package com.yk.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yk.common.resp.CommonResult;
import com.yk.model.dto.ejldxfz.EjldxfzSearchDto;
import com.yk.model.entity.Ejldxfz;
import com.yk.model.entity.SgsApiData;
import com.yk.service.SgsApiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 2022年和对讲信息表 前端控制器
 * </p>
 *
 * @author yangk
 * @since 2022-11-01
 */
@RestController
@RequestMapping("/sgsApiData")
public class SgsApiDataController {

    @Autowired
    private SgsApiDataService service;

    @GetMapping("getUidByUsername")
    public CommonResult<String> getUidByUsername(String username){
        if (StringUtils.isBlank(username)) {
            return CommonResult.error("参数错误");
        }

        String userId = service.lambdaQuery()
                .eq(SgsApiData::getUserName, username)
                .list().stream()

                .map(SgsApiData::getUserId)
                .findFirst()
                .orElse(null);

        return CommonResult.success(userId);
    }


}

