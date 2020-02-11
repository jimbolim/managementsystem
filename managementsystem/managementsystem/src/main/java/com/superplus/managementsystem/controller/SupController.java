package com.superplus.managementsystem.controller;


import com.superplus.managementsystem.bean.RespBean;
import com.superplus.managementsystem.bean.Supplier;
import com.superplus.managementsystem.service.SupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/supplier/basic")
public class SupController {
    @Autowired
    SupService supService;

    @RequestMapping(value = "/sup", method = RequestMethod.GET)
    public Map<String, Object> getSupplierByPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "") String keywords
    ) {

        Map<String, Object> map = new HashMap<>();
        List<Supplier> supplierByPage = supService.getSupplierByPage(page, size, keywords);
        Long count = supService.getCountByKeywords(keywords);
        map.put("sups", supplierByPage);
        map.put("count", count);
        return map;

    }


    @RequestMapping("/maxWorkID")
    public String maxWorkID() {
        return String.format("%08d", supService.getMaxWorkID() + 1);
    }

    @RequestMapping(value = "/sup", method = RequestMethod.POST)
    public RespBean addSup(Supplier supplier) {
        if (supService.addSup(supplier) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @RequestMapping(value = "/sup", method = RequestMethod.PUT)
    public RespBean updateSup(Supplier supplier) {
        if (supService.updateSup(supplier) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping(value = "/sup", method = RequestMethod.DELETE)
    public RespBean deleteSupById(@RequestParam(defaultValue = "") String ids) {
        if (supService.deleteSupById(ids)) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

}
