package com.yk.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yk.common.resp.CommonResult;
import com.yk.common.resp.PagedResult;
import com.yk.model.dto.ejldxfz.EjldxfzSearchDto;
import com.yk.model.dto.ejldxfz.EjldxfzUpdateDto;
import com.yk.model.entity.Ejldxfz;
import com.yk.model.entity.Yjldxfz;
import com.yk.service.EjldxfzService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangk
 * @since 2022-10-30
 */
@RestController
@RequestMapping("/ejldxfz")
public class EjldxfzController {

    @Autowired
    private EjldxfzService ejldxfzService;

    @GetMapping("list")
    public PagedResult<Ejldxfz> list(EjldxfzSearchDto dto){

        Integer pageNum = dto.getPage();
        Integer pageSize = dto.getSize();
        if (pageNum == null || pageSize == null) {
            return PagedResult.error(500, "参数错误");
        }
        Page<Ejldxfz> page = new Page<>(pageNum, pageSize);

        Wrapper<Ejldxfz> wrapper = Wrappers.<Ejldxfz>lambdaQuery()
                .like(StringUtils.isNotBlank(dto.getXqxfz()),Ejldxfz::getXqxfz, dto.getXqxfz())
                .like(StringUtils.isNotBlank(dto.getSj()),Ejldxfz::getSj, dto.getSj())
                .like(StringUtils.isNotBlank(dto.getFzr()),Ejldxfz::getFzr, dto.getFzr());

        Page<Ejldxfz> pageResult = ejldxfzService.page(page, wrapper);

        List<Ejldxfz> records = pageResult.getRecords();
        long total = pageResult.getTotal();

        return PagedResult.ok(records, total);

    }

    @PostMapping("update")
    public CommonResult<Boolean> update(@RequestBody EjldxfzUpdateDto dto){

        boolean result = ejldxfzService.lambdaUpdate()
                .eq(Ejldxfz::getId, dto.getId())
                .set(Ejldxfz::getZd, StringUtils.isBlank(dto.getZd()) ? null : dto.getZd())
                .set(Ejldxfz::getXqxfz, StringUtils.isBlank(dto.getXqxfz()) ? null : dto.getXqxfz())
                .set(Ejldxfz::getFzr, StringUtils.isBlank(dto.getFzr()) ? null : dto.getFzr())
                .set(Ejldxfz::getBzb, StringUtils.isBlank(dto.getBzb()) ? null : dto.getBzb())
                .set(Ejldxfz::getSj, StringUtils.isBlank(dto.getSj()) ? null : dto.getSj())
                .set(Ejldxfz::getZdy, StringUtils.isBlank(dto.getZdy()) ? null : dto.getZdy())
                .set(Ejldxfz::getZh, StringUtils.isBlank(dto.getZh()) ? null : dto.getZh())
                .update();

        return CommonResult.success(result);
    }

    @PostMapping("create")
    public CommonResult<Boolean> create(@RequestBody EjldxfzUpdateDto dto){

        Ejldxfz record = new Ejldxfz();
        BeanUtils.copyProperties(dto, record);

        return CommonResult.success(ejldxfzService.save(record));
    }

    @GetMapping("delete")
    public CommonResult<Boolean> delete(Integer id){
        if (id == null) {
            return CommonResult.error("参数错误");
        }

        return CommonResult.success(ejldxfzService.removeById(id));
    }

}

