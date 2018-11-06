package com.viol3t.tmall.service;

import com.viol3t.tmall.pojo.Product;

import java.util.List;

public interface ProductService {
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    List list(int cid);
    //新增--》产品图片
    void setFirstProductImage(Product p);
}
