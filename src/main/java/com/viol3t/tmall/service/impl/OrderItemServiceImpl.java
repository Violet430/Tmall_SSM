package com.viol3t.tmall.service.impl;

import com.viol3t.tmall.mapper.OrderItemMapper;
import com.viol3t.tmall.pojo.Order;
import com.viol3t.tmall.pojo.OrderItem;
import com.viol3t.tmall.pojo.OrderItemExample;
import com.viol3t.tmall.pojo.Product;
import com.viol3t.tmall.service.OrderItemService;
import com.viol3t.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    ProductService productService;

    @Override
    public void add(OrderItem orderItem){
        orderItemMapper.insert(orderItem);
    }
    @Override
    public void delete(int id){
        orderItemMapper.deleteByPrimaryKey(id);
    }
    @Override
    public void update(OrderItem orderItem){
        orderItemMapper.updateByPrimaryKeySelective(orderItem);
    }

    @Override
    public OrderItem get(int id) {
        OrderItem result = orderItemMapper.selectByPrimaryKey(id);
        setProduct(result);
        return result;
    }

    @Override
    public List list() {
        OrderItemExample example = new OrderItemExample();
        example.setOrderByClause("id desc");
        return orderItemMapper.selectByExample(example);
    }

    @Override
    public void fill(List<Order> orders) {
        for(Order order:orders){
            fill(order);
        }
    }

    public void fill(Order order){
        OrderItemExample example = new OrderItemExample();
        example.createCriteria().andOidEqualTo(order.getId());
        example.setOrderByClause("id desc");
        List<OrderItem> orderItems = orderItemMapper.selectByExample(example);
        setProduct(orderItems);

        float total = 0;
        int totalNumber = 0;
        for(OrderItem orderItem:orderItems){
            total += orderItem.getNumber()*orderItem.getProduct().getPromotePrice();
            totalNumber += orderItem.getNumber();
        }

        order.setTotal(total);
        order.setTotalNumber(totalNumber);
        order.setOrderItems(orderItems);
    }


    public void setProduct(OrderItem orderItem){
        Product p = productService.get(orderItem.getPid());
        productService.setFirstProductImage(p);
        orderItem.setProduct(p);
    }
    public void setProduct(List<OrderItem> orderItems){
        for (OrderItem orderItem:orderItems){
            setProduct(orderItem);
        }
    }

    @Override
    public int getSaleCount(int pid) {
        OrderItemExample example = new OrderItemExample();
        example.createCriteria().andPidEqualTo(pid);
        List<OrderItem> ois = orderItemMapper.selectByExample(example);
        int result = 0;
        for(OrderItem oi:ois){
            result+=oi.getNumber();
        }
        return result;
    }

    @Override
    public List<OrderItem> listByUser(int uid) {
        OrderItemExample example = new OrderItemExample();
        example.createCriteria().andUidEqualTo(uid);
        List<OrderItem> result = orderItemMapper.selectByExample(example);
        setProduct(result);
        return result;
    }
}
