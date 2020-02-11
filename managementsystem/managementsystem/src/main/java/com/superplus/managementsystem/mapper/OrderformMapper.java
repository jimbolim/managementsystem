package com.superplus.managementsystem.mapper;

import com.superplus.managementsystem.bean.Orderform;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderformMapper {

    int addOrderform(@Param("orders")List<Orderform> orderforms);

//    int countByExample(OrderformExample example);
//
//    int deleteByExample(OrderformExample example);
//
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Orderform record);
//
//    int insertSelective(Orderform record);
//
//    List<Orderform> selectByExample(OrderformExample example);
//
//    Orderform selectByPrimaryKey(Integer id);
//
//    int updateByExampleSelective(@Param("record") Orderform record, @Param("example") OrderformExample example);
//
//    int updateByExample(@Param("record") Orderform record, @Param("example") OrderformExample example);
//
//    int updateByPrimaryKeySelective(Orderform record);
//
//    int updateByPrimaryKey(Orderform record);
}