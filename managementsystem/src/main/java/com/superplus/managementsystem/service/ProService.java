package com.superplus.managementsystem.service;


import com.superplus.managementsystem.bean.Product;
import com.superplus.managementsystem.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProService {

    @Autowired
    ProductMapper proMapper;


    public List<Product> getProductByPage(Integer page, Integer size, String keywords) {
        int start = (page - 1) * size;
        return proMapper.getProductByPage(start, size, keywords);
    }

    public Long getCountByKeywords(String keywords) {
        return proMapper.getCountByKeywords(keywords);
    }

    public List<Product> getAllProducts() {
        return proMapper.getAllProducts();
    }

    public Long getMaxWorkID() {
        Long maxWorkID = proMapper.getMaxWorkID();
        return maxWorkID == null ? 0 : maxWorkID;
    }

    public int updatePro(Product product) {
        return proMapper.updatePro(product);
    }

    public int addPro(Product product) {
        return proMapper.addPro(product);
    }

    public int addPros(List<Product> pros) {
        return proMapper.addPros(pros);
    }

    public boolean deleteProById(String ids) {
        String[] split = ids.split(",");
        return proMapper.deleteProById(split) == split.length;
    }

    public List<Long> getIdBySkunum(String keyword){
        return proMapper.getIdBySkunum(keyword);
    }


    //插入
    public int insertUrl(String name,String lujing,String url, Long pid){
        System.out.print("开始插入=name=="+name+"\n");
        System.out.print("开始插入=lujing=="+lujing+"\n");
        System.out.print("开始插入=url=="+url+"\n");
        int jieguo = proMapper.insertUrl(name,lujing,url,pid);
        System.out.print("插入结果==="+jieguo+"\n");
        return jieguo;
    }

    public List<String> getPic(Long pid){
        return proMapper.getPic(pid);
    }
}
