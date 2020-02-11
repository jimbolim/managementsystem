package com.superplus.managementsystem.service;


import com.superplus.managementsystem.bean.Customer;
import com.superplus.managementsystem.bean.Orderform;
import com.superplus.managementsystem.bean.Orders;
import com.superplus.managementsystem.mapper.CustomerMapper;
import com.superplus.managementsystem.mapper.OrderformMapper;
import com.superplus.managementsystem.mapper.OrdersMapper;
import com.superplus.managementsystem.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CusService {

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    OrderformMapper orderformMapper;

    @Autowired
    ProductMapper productMapper;

    public List<Customer> getCus(Integer page, Integer size, String keywords){
        int start = (page - 1) * size;
        return customerMapper.getCus(start, size, keywords);
    }

    public int addCus(Customer customer){
        return customerMapper.addCus(customer);
    }

    public List<Orders> getOrders(Long cid){
        return ordersMapper.getOrders(cid);
    }

    public int addOrders(Orders orders, int cid){
        return ordersMapper.addOrders(orders, cid);
    }

    public int updateCus(Customer customer){
        return customerMapper.updateCus(customer);
    }


    public int deleteCus(Long cid){
        return customerMapper.deleteCus(cid);
    }

    public Long getCusId(){
        Long cusid = customerMapper.getCusId();
        return cusid == null ? 0 : cusid;
    }

    public Long getOrdersId(){
        Long ordersid = ordersMapper.getOrdersId();
        return ordersid == null ? 0 : ordersid;
    }

    public int updateOrders(Orders orders){
        return ordersMapper.updateOrders(orders);
    }

    public int deleteOrder(Long id){
        return ordersMapper.deleteOrder(id);
    }

    public boolean importOrder(List<Orderform> orderforms,int oid){
        int n = 0;
        for(Orderform orderform:orderforms){
            orderform.setOid(oid);
            try {
                orderform.setPurchaseprice(productMapper.getpp(orderform.getSku(), orderform.getSize()));
            }catch (Exception e){}
            n+=1;
        }
        return orderformMapper.addOrderform(orderforms) == n ? true : false;
    }
}
