package com.superplus.managementsystem.service;


import com.superplus.managementsystem.bean.Product;
import com.superplus.managementsystem.bean.Supplier;
import com.superplus.managementsystem.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupService {

    @Autowired
    SupplierMapper supMapper;


    public List<Supplier> getSupplierByPage(Integer page, Integer size, String keywords) {
        int start = (page - 1) * size;
        return supMapper.getSupplierByPage(start, size, keywords);
    }

    public Long getCountByKeywords(String keywords) {
        return supMapper.getCountByKeywords(keywords);
    }

    public boolean deleteSupById(String id){
        return supMapper.deleteSupById(id) == 1;
    }

    public Long getMaxWorkID() {
        Long maxWorkID = supMapper.getMaxWorkID();
        return maxWorkID == null ? 0 : maxWorkID;
    }

    public int addSup(Supplier supplier){
        return supMapper.addSup(supplier);
    }

    public int updateSup(Supplier supplier) {
        return supMapper.updateSup(supplier);
    }

}
