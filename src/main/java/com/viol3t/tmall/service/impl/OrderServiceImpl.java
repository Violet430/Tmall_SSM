package com.viol3t.tmall.service.impl;

import com.viol3t.tmall.mapper.OrderMapper;
import com.viol3t.tmall.pojo.Order;
import com.viol3t.tmall.pojo.OrderExample;
import com.viol3t.tmall.pojo.User;
import com.viol3t.tmall.service.OrderService;
import com.viol3t.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserService userService;

    @Override
    public void add(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public void delete(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Order get(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    public List<Order> list(){
        OrderExample example = new OrderExample();
        example.setOrderByClause("id desc");
        List<Order> result = orderMapper.selectByExample(example);
        setUser(result);
        return result;
    }

    public void setUser(Order order){
        int uid = order.getUid();
        User user = userService.get(uid);
        order.setUser(user);
    }

    public void setUser(List<Order> orders){
        for(Order order:orders){
            setUser(order);
        }
    }



}
