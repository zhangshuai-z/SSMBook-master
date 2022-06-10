package com.snwjas.ssmbook.service.impl;

import com.snwjas.ssmbook.mapper.UserMapper;
import com.snwjas.ssmbook.model.entity.UserEntity;
import com.snwjas.ssmbook.model.vo.UserVO;
import com.snwjas.ssmbook.service.UserService;
import org.springframework.stereotype.Service;

/**
 * User Service implement
 *
 * @author snwjas
 */
@Service
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	@Override
	public UserVO getByPhone(String phone) {
		UserEntity byPhone = userMapper.getByPhone(phone);
		return new UserVO().convertFrom(byPhone);
	}
}
