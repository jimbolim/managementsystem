package com.superplus.managementsystem.controller;

import com.superplus.managementsystem.bean.Customer;
import com.superplus.managementsystem.bean.Orderform;
import com.superplus.managementsystem.bean.Orders;
import com.superplus.managementsystem.bean.RespBean;
import com.superplus.managementsystem.common.test.PoiUtils;
import com.superplus.managementsystem.service.CusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/customer/basic")
public class CustomController {

    @Autowired
    CusService cusService;

    @RequestMapping(value = "/cusid")
    public String getCusId(){
        return String.format("%08d", cusService.getCusId() + 1);
    }

    @RequestMapping(value = "/ordersid")
    public String getOrdersId(){
        return String.format("%08d", cusService.getOrdersId() + 1);
    }

    @RequestMapping(value = "/cus", method = RequestMethod.GET)
    public Map<String, Object>  getCus(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "") String keywords){
        Map<String, Object> map = new HashMap<>();
        List<Customer> customers = cusService.getCus(page, size, keywords);
        map.put("cuss", customers);
        return map;
    }

    @RequestMapping(value = "/cus",  method = RequestMethod.POST)
    public RespBean addCus(Customer customer){
        if(cusService.addCus(customer)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @RequestMapping(value = "/cus", method = RequestMethod.PUT)
    public RespBean updateCus(Customer customer){
        if (cusService.updateCus(customer)==1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @RequestMapping(value = "/cus", method = RequestMethod.DELETE)
    public RespBean deleteCus(@RequestParam(defaultValue = "")Long ids){
        if(cusService.deleteCus(ids)==1){
                return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public Map<String,Object> getorder(@RequestParam(defaultValue = "") Long cid){
        Map<String, Object> map = new HashMap<>();
        List<Orders> orders = cusService.getOrders(cid);
        map.put("orders", orders);
        return map;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public RespBean addOrders(Orders orders,@RequestParam(defaultValue = "")int cid){
        if(cusService.addOrders(orders,cid)==1){
                return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }


    @RequestMapping(value = "/orders", method = RequestMethod.PUT)
    public RespBean updateOrders(Orders orders){
        if(cusService.updateOrders(orders)==1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }


    @RequestMapping(value = "/order", method = RequestMethod.DELETE)
    public RespBean deleteOrder(@RequestParam(defaultValue = "")Long ids){
        if (cusService.deleteOrder(ids)==1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @RequestMapping(value = "/importorder", method = RequestMethod.POST)
    public RespBean importOrder(MultipartFile file, @RequestParam(defaultValue = "")int oid){
        List<Orderform> orderforms = PoiUtils.importOrdersList(file);
        if(cusService.importOrder(orderforms,oid)){
            return RespBean.ok("导入成功");
        }
        return RespBean.error("导入失败");
    }
}
