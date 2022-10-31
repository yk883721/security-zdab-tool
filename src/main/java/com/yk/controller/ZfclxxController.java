package com.yk.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yk.common.resp.CommonResult;
import com.yk.model.dto.zfclxx.ZfclxxSearchDto;
import com.yk.model.dto.zfclxx.ZfclxxUpdateDto;
import com.yk.model.entity.Zfclxx;
import com.yk.service.ZfclxxService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 驻防车辆信息 前端控制器
 * </p>
 *
 * @author yangk
 * @since 2022-10-30
 */
@RestController
@RequestMapping("/zfclxx")
public class ZfclxxController {

    @Autowired
    private ZfclxxService zfclxxService;

    @GetMapping("list")
    public CommonResult<List<Zfclxx>> list(ZfclxxSearchDto dto){

        Wrapper<Zfclxx> wrapper = Wrappers.<Zfclxx>lambdaQuery()
                .like(StringUtils.isNotBlank(dto.getHh()), Zfclxx::getHh, dto.getHh());

        return CommonResult.success(zfclxxService.list(wrapper));
    }

    @PostMapping("update")
    public CommonResult<Boolean> update(@RequestBody ZfclxxUpdateDto dto){

        boolean result = zfclxxService.lambdaUpdate()
                .eq(Zfclxx::getId, dto.getId())
                .set(Zfclxx::getCph, StringUtils.isBlank(dto.getCph()) ? null : dto.getCph())
                .set(Zfclxx::getYhh, StringUtils.isBlank(dto.getYhh()) ? null : dto.getYhh())
                .set(Zfclxx::getGbid, StringUtils.isBlank(dto.getGbid()) ? null : dto.getGbid())
                .update();

        return CommonResult.success(result);
    }

    @PostMapping("create")
    public CommonResult<Boolean> create(@RequestBody ZfclxxUpdateDto dto){

        Zfclxx record = new Zfclxx();
        BeanUtils.copyProperties(dto, record);

        return CommonResult.success(zfclxxService.save(record));
    }

    @GetMapping("delete")
    public CommonResult<Boolean> delete(Integer id){
        if (id == null) {
            return CommonResult.error("参数错误");
        }

        return CommonResult.success(zfclxxService.removeById(id));
    }

}

