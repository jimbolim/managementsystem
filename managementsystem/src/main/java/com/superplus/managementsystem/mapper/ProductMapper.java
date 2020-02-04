package com.superplus.managementsystem.mapper;

import com.superplus.managementsystem.bean.Product;
import com.superplus.managementsystem.bean.ProductExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ProductMapper {

    List<Product> getProductByPage(@Param("start") Integer start, @Param("size") Integer size, @Param("keywords") String keywords);

    Long getCountByKeywords(@Param("keywords") String keywords);

    List<Product> getAllProducts();

    Long getMaxWorkID();

    int updatePro(@Param("pro") Product product);

    int addPro(Product product);

    int addPros(@Param("pros") List<Product> pros);

    int deleteProById(@Param("ids") String[] ids);

    int insertUrl(@Param("name")String name,@Param("lujing")String lujing,@Param("url")String url,@Param("pid")Long pid);

    List<Long> getIdBySkunum(@Param("keyword")String keyword);

    List<String> getPic(@Param("pid")Long pid);

    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}