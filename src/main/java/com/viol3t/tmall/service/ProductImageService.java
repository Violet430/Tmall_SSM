package com.viol3t.tmall.service;

import com.viol3t.tmall.pojo.ProductImage;

import java.util.List;

public interface ProductImageService {
    //单张图片和详情图片
    String type_single = "type_single";
    String type_detail = "type_detail";

    void add(ProductImage pi);
    void delete(int id);
    void update(ProductImage pi);
    ProductImage get(int id);
    List list(int pid, String type);
}
