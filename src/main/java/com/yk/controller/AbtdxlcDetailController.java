package com.yk.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yk.common.resp.CommonResult;
import com.yk.common.resp.PagedResult;
import com.yk.model.dto.abtdxlc.XlcSearchDto;
import com.yk.model.dto.abtdxlc.XlcUpdateDto;
import com.yk.model.entity.AbtdxlcDetail;
import com.yk.service.AbtdxlcDetailService;
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
 * @since 2022-11-03
 */
@RestController
@RequestMapping("/abtdxlcDetail")
public class AbtdxlcDetailController {

    @Autowired
    private AbtdxlcDetailService service;

    @GetMapping("list")
    public PagedResult<AbtdxlcDetail> list(XlcSearchDto dto){

        Integer pageNum = dto.getPage();
        Integer pageSize = dto.getSize();
        if (pageNum == null || pageSize == null) {
            return PagedResult.error(500, "参数错误");
        }
        Page<AbtdxlcDetail> page = new Page<>(pageNum, pageSize);

        Wrapper<AbtdxlcDetail> wrapper = Wrappers.<AbtdxlcDetail>lambdaQuery()
                .like(StringUtils.isNotBlank(dto.getMc()),AbtdxlcDetail::getMc, dto.getMc())
                .like(StringUtils.isNotBlank(dto.getQy()),AbtdxlcDetail::getQy, dto.getQy())
                .like(StringUtils.isNotBlank(dto.getCldh()),AbtdxlcDetail::getCldh, dto.getCldh());

        Page<AbtdxlcDetail> pageResult = service.page(page, wrapper);

        List<AbtdxlcDetail> records = pageResult.getRecords();
        long total = pageResult.getTotal();

        return PagedResult.ok(records, total);

    }

    @PostMapping("update")
    public CommonResult<Boolean> update(@RequestBody XlcUpdateDto dto){

        boolean result = service.lambdaUpdate()
                .eq(AbtdxlcDetail::getId, dto.getId())
                .set(AbtdxlcDetail::getMc, StringUtils.isBlank(dto.getMc()) ? null : dto.getMc())
                .set(AbtdxlcDetail::getLxfs, StringUtils.isBlank(dto.getLxfs()) ? null : dto.getLxfs())
                .set(AbtdxlcDetail::getQy, StringUtils.isBlank(dto.getQy()) ? null : dto.getQy())
                .set(AbtdxlcDetail::getCldh, StringUtils.isBlank(dto.getCldh()) ? null : dto.getCldh())
                .set(AbtdxlcDetail::getZh, StringUtils.isBlank(dto.getZh()) ? null : dto.getZh())
                .set(AbtdxlcDetail::getUid, StringUtils.isBlank(dto.getUid()) ? null : dto.getUid())
                .set(AbtdxlcDetail::getJd, StringUtils.isBlank(dto.getJd()) ? null : dto.getJd())
                .set(AbtdxlcDetail::getWd, StringUtils.isBlank(dto.getWd()) ? null : dto.getWd())
                .set(AbtdxlcDetail::getCdJd, StringUtils.isBlank(dto.getCdJd()) ? null : dto.getCdJd())
                .set(AbtdxlcDetail::getCdWd, StringUtils.isBlank(dto.getCdWd()) ? null : dto.getCdWd())
                .set(AbtdxlcDetail::getUpdateTime, new Date())
                .update();

        return CommonResult.success(result);
    }

    @PostMapping("create")
    public CommonResult<Boolean> create(@RequestBody XlcUpdateDto dto){

        AbtdxlcDetail record = new AbtdxlcDetail();
        BeanUtils.copyProperties(dto, record);

        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
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

