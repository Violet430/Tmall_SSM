package com.viol3t.tmall.service.impl;

import com.viol3t.tmall.mapper.CategoryMapper;
import com.viol3t.tmall.mapper.ProductMapper;
import com.viol3t.tmall.pojo.Category;
import com.viol3t.tmall.pojo.Product;
import com.viol3t.tmall.pojo.ProductExample;
import com.viol3t.tmall.service.CategoryService;
import com.viol3t.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;

    @Override
    public void add(Product p){
        productMapper.insert(p);
    }

    @Override
    public void delete(int id){
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Product p){
        productMapper.updateByPrimaryKeySelective(p);
    }

    @Override
    public Product get(int id){
        Product p = productMapper.selectByPrimaryKey(id);
        setCategory(p);
        return p;
    }

    public void setCategory(Product p){
        int cid = p.getCid();
        Category c = categoryService.get(cid);
        p.setCategory(c);
    }
    public void setCategory(List<Product> ps){
        for(Product p:ps)
            setCategory(p);
    }

    @Override
    public List list(int cid){
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        List result = productMapper.selectByExample(example);
        setCategory(result);
        return result;
    }
}
