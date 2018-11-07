package com.viol3t.tmall.service;

import com.viol3t.tmall.pojo.Order;

import java.util.List;

public interface OrderService {
    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";

    void add(Order order);
    void delete(int id);
    void update(Order order);
    Order get(int id);
    List list();
}
