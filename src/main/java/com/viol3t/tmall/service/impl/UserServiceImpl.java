package com.viol3t.tmall.service.impl;

import com.viol3t.tmall.mapper.UserMapper;
import com.viol3t.tmall.pojo.User;
import com.viol3t.tmall.pojo.UserExample;
import com.viol3t.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void add(User user){
        userMapper.insert(user);
    }
    @Override
    public void delete(int id){
        userMapper.deleteByPrimaryKey(id);
    }
    @Override
    public void update(User user){
        userMapper.updateByPrimaryKeySelective(user);
    }
    @Override
    public User get(int id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> list(){
        UserExample example = new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
    }

    @Override
    public boolean isExist(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> result = userMapper.selectByExample(example);
        if (!result.isEmpty()){
            return true;
        }
        return false;
    }
}
