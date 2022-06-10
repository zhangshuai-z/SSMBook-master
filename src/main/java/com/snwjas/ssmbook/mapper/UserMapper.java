package com.snwjas.ssmbook.mapper;

import com.snwjas.ssmbook.model.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * User Mapper
 *
 * @author snwjas
 */
public interface UserMapper {


	/**
	 * 根据手机号密码获取用户信息
	 *
	 * @param phone 用户名
	 * @return 用户实体
	 */
	UserEntity getByPhone(@Param("phone") String phone);
}
