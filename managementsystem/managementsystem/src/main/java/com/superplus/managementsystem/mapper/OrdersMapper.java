package com.superplus.managementsystem.mapper;

import com.superplus.managementsystem.bean.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface OrdersMapper {

      List<Orders> getOrders(@Param("cid") Long cid);

      int addOrders(@Param("order") Orders orders,@Param("cid") int cid);

      Long getOrdersId();

      int updateOrders(@Param("order")Orders orders);

      int deleteOrder(@Param("id")Long id );


//    int countByExample(OrdersExample example);
//
//    int deleteByExample(OrdersExample example);
//
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Orders record);
//
//    int insertSelective(Orders record);
//
//    List<Orders> selectByExample(OrdersExample example);
//
//    Orders selectByPrimaryKey(Integer id);
//
//    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);
//
//    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);
//
//    int updateByPrimaryKeySelective(Orders record);
//
//    int updateByPrimaryKey(Orders record);
}