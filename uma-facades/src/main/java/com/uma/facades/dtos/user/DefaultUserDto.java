package com.uma.facades.dtos.user;

import com.uma.facades.dtos.GenericDto;
import com.uma.facades.util.FacadesConstants;

public class DefaultUserDto extends GenericDto {
	
	private Long id;

	private String email;

	private String password;

	private String nickname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String getUri() {
		return FacadesConstants.URI.USERS_URI + id;
	}
}
