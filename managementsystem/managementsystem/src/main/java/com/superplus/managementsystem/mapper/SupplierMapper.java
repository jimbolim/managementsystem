package com.superplus.managementsystem.mapper;

import com.superplus.managementsystem.bean.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMapper {

    List<Supplier> getSupplierByPage(@Param("start") Integer start, @Param("size") Integer size, @Param("keywords") String keywords);

    Long getCountByKeywords(@Param("keywords") String keywords);

    int deleteSupById(@Param("id") String id);

    Long getMaxWorkID();

    int addSup(Supplier supplier);

    int updateSup(@Param("sup") Supplier supplier);

//    int countByExample(SupplierExample example);
//
//    int deleteByExample(SupplierExample example);
//
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Supplier record);
//
//    int insertSelective(Supplier record);
//
//    List<Supplier> selectByExample(SupplierExample example);
//
//    Supplier selectByPrimaryKey(Integer id);
//
//    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);
//
//    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);
//
//    int updateByPrimaryKeySelective(Supplier record);
//
//    int updateByPrimaryKey(Supplier record);
}