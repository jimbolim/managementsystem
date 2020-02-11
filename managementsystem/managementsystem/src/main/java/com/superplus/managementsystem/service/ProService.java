package com.superplus.managementsystem.service;


import com.superplus.managementsystem.bean.Product;
import com.superplus.managementsystem.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

@Service
@Transactional
public class ProService {

    @Autowired
    ProductMapper proMapper;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
        product.setProductid(product.getSkunumber()+'-'+product.getSize());
        try{
            product.setUpdatetime(simpleDateFormat.parse(simpleDateFormat.format(product.getUpdatetime())));
        }
        catch (ParseException e) {}
        return proMapper.updatePro(product);
    }

    public int addPro(Product product) {
        product.setProductid(product.getSkunumber()+'-'+product.getSize());
        try{
            product.setUpdatetime(simpleDateFormat.parse(simpleDateFormat.format(product.getUpdatetime())));
            }
        catch (ParseException e) {}
        return proMapper.addPro(product);
    }

    public int addPros(List<Product> pros) {
        for(Product pro:pros){
            pro.setProductid(pro.getSkunumber()+'-'+pro.getSize());
            try{
                pro.setUpdatetime(simpleDateFormat.parse(simpleDateFormat.format(pro.getUpdatetime())));
            }
            catch (ParseException e) {}
            System.out.println(pro.getUpdatetime());
        }
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
        int jieguo = proMapper.insertUrl(name,lujing,url,pid);
        return jieguo;
    }

    public List<String> getPic(Long pid){
        return proMapper.getPic(pid);
    }

    public String getPicUrl(int id){
        return proMapper.getPicUrl(id);
    }
}
