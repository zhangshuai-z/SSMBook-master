package com.snwjas.ssmbook.model.entity;

import com.snwjas.ssmbook.support.Mobile;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户实体类
 *
 * @author snwjas
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class UserEntity extends BaseEntity {

	private Integer id;

	private String username;

	private String password;

	private String phone;

	private String nickname;

	private String description;

	private String role;

	private UserEntity(Integer id, String username, String password, String phone, String nickname, String description, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.nickname = nickname;
		this.description = description;
		this.role = role;
	}

	public UserEntity() {
	}

	public static UserBuilder builder() {
		return new UserBuilder();
	}

	public UserEntity build() {
		if (username == null || password == null) {
			throw new RuntimeException("用户名和密码必填");
		}
		Mobile mobile = new Mobile();
		boolean mobileIsTrue = mobile.isMobile(phone);
		// 还可以做赋予”默认值“的功能
		if (!mobileIsTrue) {
			throw new RuntimeException("手机号格式不正确");
		}
		return new UserEntity(id, username, password, phone, nickname, description, role);
	}



	public static class UserBuilder{
		private Integer id;

		private String username;

		private String password;

		private String phone;

		private String nickname;

		private String description;

		private String role;

		private UserBuilder() {
		}

		public UserBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public UserBuilder username(String username) {
			this.username = username;
			return this;
		}

		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}

		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserBuilder nickname(String nickname) {
			this.nickname = nickname;
			return this;
		}

		public UserBuilder description(String description) {
			this.description = description;
			return this;
		}

		public UserBuilder role(String role) {
			this.role = role;
			return this;
		}

	}
}
