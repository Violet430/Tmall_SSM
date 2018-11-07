package com.viol3t.tmall.service;

import com.viol3t.tmall.pojo.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(int id);
    void update(User user);
    User get(int id);
    List list();
}
