package com.snwjas.ssmbook.service.impl;

import com.snwjas.ssmbook.mapper.UserThirdMapper;
import com.snwjas.ssmbook.model.entity.UserEntity;
import com.snwjas.ssmbook.model.enums.RoleEnum;
import com.snwjas.ssmbook.model.vo.UserVO;
import com.snwjas.ssmbook.service.UserService;
import com.snwjas.ssmbook.service.UserThirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserThirdServiceImpl implements UserThirdService {


    private final UserThirdMapper userThirdMapper;

    public UserThirdServiceImpl(UserThirdMapper userThirdMapper) {
        this.userThirdMapper = userThirdMapper;
    }

    @Override
    public UserVO getByUsername(String username) {
        UserEntity userEntity = userThirdMapper.getByUsername(username);
        return new UserVO().convertFrom(userEntity);
    }

    @Override
    public int saveUser(UserVO userVO) {
        UserEntity userEntity = userVO.convertTo(new UserEntity());
        return userThirdMapper.saveUser(userEntity);
    }

    @Override
    public int updateUser(UserVO userVO) {
        UserEntity userEntity = userVO.convertTo(new UserEntity());
        return userThirdMapper.updateUser(userEntity);
    }

    @Override
    public int deleteUseById(int userId) {
        return userThirdMapper.deleteUseById(userId);
    }

    @Override
    public List<RoleEnum> listRoles() {
        return Arrays.asList(RoleEnum.values());
    }

    @Autowired
    private UserService userService;

    @Override
    public UserVO getByPhone(String phone) {
        return userService.getByPhone(phone);
    }
}

