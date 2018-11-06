package com.viol3t.tmall.service;

import com.viol3t.tmall.pojo.Product;
import com.viol3t.tmall.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueService {
    void init(Product p);
    void update(PropertyValue pv);

    //属性id和产品id
    PropertyValue get(int ptid,int pid);
    List<PropertyValue> list(int pid);
}
