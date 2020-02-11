package com.superplus.managementsystem.mapper;

import com.superplus.managementsystem.bean.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.temporal.ChronoUnit;
import java.util.List;

public interface CustomerMapper {

      List<Customer> getCus(@Param("start") Integer start, @Param("size") Integer size, @Param("keywords") String keywords);

      int addCus(Customer customer);

      Long getCusId();

      int deleteCus(@Param("cid") Long cid);

      int updateCus(@Param("cus") Customer customer);

//    int countByExample(CustomerExample example);
//
//    int deleteByExample(CustomerExample example);
//
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Customer record);
//
//    int insertSelective(Customer record);
//
//    List<Customer> selectByExample(CustomerExample example);
//
//    Customer selectByPrimaryKey(Integer id);
//
//    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);
//
//    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);
//
//    int updateByPrimaryKeySelective(Customer record);
//
//    int updateByPrimaryKey(Customer record);
}