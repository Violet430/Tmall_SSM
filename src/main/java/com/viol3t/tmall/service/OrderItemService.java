package com.viol3t.tmall.service;

import com.viol3t.tmall.pojo.Order;
import com.viol3t.tmall.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {
    void add(OrderItem orderItem);
    void delete(int id);
    void update(OrderItem orderItem);
    OrderItem get(int id);
    List list();


    /**
     * 订单与订单项一对多关系
     *
     * @param orders
     */
    void fill(List<Order> orders);
    void fill(Order order);
}
