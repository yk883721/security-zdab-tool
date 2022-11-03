package com.yk.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yk.common.resp.CommonResult;
import com.yk.common.resp.PagedResult;
import com.yk.model.dto.sdq_wxxfz.SdqWxxfzSearchDto;
import com.yk.model.dto.sdq_wxxfz.SdqWxxfzUpdateDto;
import com.yk.model.dto.zfclxx.ZfclxxSearchDto;
import com.yk.model.dto.zfclxx.ZfclxxUpdateDto;
import com.yk.model.entity.SSdqWxxfz2022;
import com.yk.model.entity.Zfclxx;
import com.yk.service.SSdqWxxfz2022Service;
import com.yk.service.ZfclxxService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangk
 * @since 2022-10-31
 */
@RestController
@RequestMapping("/sSdqWxxfz2022")
public class SSdqWxxfz2022Controller {

    @Autowired
    private SSdqWxxfz2022Service service;

    @GetMapping("list")
    public PagedResult<SSdqWxxfz2022> list(SdqWxxfzSearchDto dto){

        Integer pageNum = dto.getPage();
        Integer pageSize = dto.getSize();
        if (pageNum == null || pageSize == null) {
            return PagedResult.error(500, "参数错误");
        }
        Page<SSdqWxxfz2022> page = new Page<>(pageNum, pageSize);

        Wrapper<SSdqWxxfz2022> wrapper = Wrappers.<SSdqWxxfz2022>lambdaQuery()
                .like(StringUtils.isNotBlank(dto.getWzMc()), SSdqWxxfz2022::getWzMc, dto.getWzMc())
                .like(StringUtils.isNotBlank(dto.getAddr()), SSdqWxxfz2022::getAddr, dto.getAddr())
                .like(StringUtils.isNotBlank(dto.getFzr()), SSdqWxxfz2022::getFzr, dto.getFzr())
                .orderByAsc(SSdqWxxfz2022::getSh);

        Page<SSdqWxxfz2022> pageResult = service.page(page, wrapper);

        List<SSdqWxxfz2022> records = pageResult.getRecords();
        long total = pageResult.getTotal();


        return PagedResult.ok(records, total);
    }

    @PostMapping("update")
    public CommonResult<Boolean> update(@RequestBody SdqWxxfzUpdateDto dto){

        boolean result = service.lambdaUpdate()
                .eq(SSdqWxxfz2022::getId, dto.getId())
                .set(SSdqWxxfz2022::getSh, dto.getSh())
                .set(SSdqWxxfz2022::getZdMc, StringUtils.isBlank(dto.getZdMc()) ? null : dto.getZdMc())
                .set(SSdqWxxfz2022::getWzMc, StringUtils.isBlank(dto.getWzMc()) ? null : dto.getWzMc())
                .set(SSdqWxxfz2022::getUnit, StringUtils.isBlank(dto.getUnit()) ? null : dto.getUnit())
                .set(SSdqWxxfz2022::getAddr, StringUtils.isBlank(dto.getAddr()) ? null : dto.getAddr())
                .set(SSdqWxxfz2022::getPhone, StringUtils.isBlank(dto.getPhone()) ? null : dto.getPhone())
                .set(SSdqWxxfz2022::getFzr, StringUtils.isBlank(dto.getFzr()) ? null : dto.getFzr())
                .set(SSdqWxxfz2022::getFzrPhone, StringUtils.isBlank(dto.getFzrPhone()) ? null : dto.getFzrPhone())
                .set(SSdqWxxfz2022::getWzkshzdmc, StringUtils.isBlank(dto.getWzkshzdmc()) ? null : dto.getWzkshzdmc())
                .set(SSdqWxxfz2022::getKshdjsbbh, StringUtils.isBlank(dto.getKshdjsbbh()) ? null : dto.getKshdjsbbh())
                .set(SSdqWxxfz2022::getJd, StringUtils.isBlank(dto.getJd()) ? null : dto.getJd())
                .set(SSdqWxxfz2022::getWd, StringUtils.isBlank(dto.getWd()) ? null : dto.getWd())
                .set(SSdqWxxfz2022::getSfpbddc, StringUtils.isBlank(dto.getSfpbddc()) ? null : dto.getSfpbddc())
                .set(SSdqWxxfz2022::getBz, StringUtils.isBlank(dto.getBz()) ? null : dto.getBz())
                .set(SSdqWxxfz2022::getUid, StringUtils.isBlank(dto.getUid()) ? null : dto.getUid())
                .set(SSdqWxxfz2022::getWzid, StringUtils.isBlank(dto.getWzid()) ? null : dto.getWzid())
                .set(SSdqWxxfz2022::getCdJd, StringUtils.isBlank(dto.getCdJd()) ? null : dto.getCdJd())
                .set(SSdqWxxfz2022::getCdWd, StringUtils.isBlank(dto.getCdWd()) ? null : dto.getCdWd())
                .set(SSdqWxxfz2022::getUpdateTime, new Date())
                .update();


        return CommonResult.success(result);
    }

    @PostMapping("create")
    public CommonResult<Boolean> create(@RequestBody SdqWxxfzUpdateDto dto){

        SSdqWxxfz2022 record = new SSdqWxxfz2022();
        BeanUtils.copyProperties(dto, record);

        return CommonResult.success(service.save(record));
    }

    @GetMapping("delete")
    public CommonResult<Boolean> delete(Integer id){
        if (id == null) {
            return CommonResult.error("参数错误");
        }

        return CommonResult.success(service.removeById(id));
    }


}

