package com.yk.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yk.common.resp.CommonResult;
import com.yk.model.dto.yjldxfz.YjldxfzSearchDto;
import com.yk.model.dto.yjldxfz.YjldxfzUpdateDto;
import com.yk.model.entity.Yjldxfz;
import com.yk.service.YjldxfzService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 一级流动消防站 前端控制器
 * </p>
 *
 * @author yangk
 * @since 2022-10-28
 */
@RestController
@RequestMapping("/yjldxfz")
public class YjldxfzController {

    @Autowired
    private YjldxfzService yjldxfzService;

    @GetMapping("gbList")
    public CommonResult<List<Yjldxfz>> list(YjldxfzSearchDto dto){

        Wrapper<Yjldxfz> wrapper = Wrappers.<Yjldxfz>lambdaQuery()
                .like(StringUtils.isNotBlank(dto.getZfcl()),Yjldxfz::getZfcl, dto.getZfcl())
                .like(StringUtils.isNotBlank(dto.getSj()),Yjldxfz::getSj, dto.getSj())
                .like(StringUtils.isNotBlank(dto.getGczh()),Yjldxfz::getGczh, dto.getGczh());

        return CommonResult.success(yjldxfzService.list(wrapper));
    }

    @PostMapping("update")
    public CommonResult<Boolean> update(@RequestBody YjldxfzUpdateDto dto){

        boolean result = yjldxfzService.lambdaUpdate()
                .eq(Yjldxfz::getId, dto.getId())
                .set(Yjldxfz::getZd, StringUtils.isBlank(dto.getZd()) ? null : dto.getZd())
                .set(Yjldxfz::getBkqid, StringUtils.isBlank(dto.getBkqid()) ? null : dto.getBkqid())
                .set(Yjldxfz::getGczh, StringUtils.isBlank(dto.getGczh()) ? null : dto.getGczh())
                .set(Yjldxfz::getBzb, StringUtils.isBlank(dto.getBzb()) ? null : dto.getBzb())
                .set(Yjldxfz::getSj, StringUtils.isBlank(dto.getSj()) ? null : dto.getSj())
                .set(Yjldxfz::getJsy, StringUtils.isBlank(dto.getJsy()) ? null : dto.getJsy())
                .set(Yjldxfz::getZdy, StringUtils.isBlank(dto.getZdy()) ? null : dto.getZdy())
                .set(Yjldxfz::getTxy, StringUtils.isBlank(dto.getTxy()) ? null : dto.getTxy())
                .update();

        return CommonResult.success(result);
    }

    @PostMapping("create")
    public CommonResult<Boolean> create(@RequestBody YjldxfzUpdateDto dto){

        Yjldxfz record = new Yjldxfz();
        BeanUtils.copyProperties(dto, record);

        return CommonResult.success(yjldxfzService.save(record));
    }

    @GetMapping("delete")
    public CommonResult<Boolean> delete(Integer id){
        if (id == null) {
            return CommonResult.error("参数错误");
        }

        return CommonResult.success(yjldxfzService.removeById(id));
    }


}

