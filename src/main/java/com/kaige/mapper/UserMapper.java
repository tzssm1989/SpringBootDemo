package com.kaige.mapper;

import com.kaige.mapper.request.Userparam;
import com.kaige.model.User;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUsers();

    User selectByLoginNameAndPassWord(Userparam userparam);
}