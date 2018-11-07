package com.viol3t.tmall.service;

import com.viol3t.tmall.pojo.Category;
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

    void fill(List<Category> cs);
    void fill(Category c);
    void fillByRow(List<Category> cs);

    void setSaleAndReviewNumber(Product product);
    void setSaleAndReviewNumber(List<Product> products);
}
