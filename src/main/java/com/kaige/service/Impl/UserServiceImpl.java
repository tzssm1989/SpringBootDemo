package com.kaige.service.Impl;

import com.kaige.mapper.UserMapper;
import com.kaige.mapper.request.Userparam;
import com.kaige.model.User;
import com.kaige.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.server.InactiveGroupException;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {

        return userMapper.insertSelective(user);

    }

    @Override
    public int editUser(User user) {

        return userMapper.updateByPrimaryKeySelective(user);

    }

    @Override
    public int deleteUser(Integer id) {

        return userMapper.deleteByPrimaryKey(id);

    }

    @Override
    public List<User> getUsers() {

         return userMapper.selectUsers();

    }

    @Override
    public User selectUserByLoginNameAndPassWord(String loginname,String password) {

        Userparam userparam = new Userparam();
        userparam.setLoginname(loginname);
        userparam.setPassword(password);

        return userMapper.selectByLoginNameAndPassWord(userparam);

    }
}
