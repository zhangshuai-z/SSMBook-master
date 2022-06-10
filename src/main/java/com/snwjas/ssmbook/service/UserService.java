package com.snwjas.ssmbook.service;

import com.snwjas.ssmbook.model.vo.UserVO;

/**
 * User Service
 *
 * @author snwjas
 */
public interface UserService {

	/**
	 * 根据手机号获取用户信息
	 *
	 * @param phone 用户名
	 * @return 用户实体
	 */
	UserVO getByPhone(String phone);

}
