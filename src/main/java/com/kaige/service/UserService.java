package com.kaige.service;

import com.kaige.model.User;

import java.util.List;

public interface UserService {

    int addUser(User user);

    int editUser(User user);

    int deleteUser(Integer id);

    List<User> getUsers();

    User selectUserByLoginNameAndPassWord(String loginname,String password);
}
