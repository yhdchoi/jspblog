package com.yhdc.jspblog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.yhdc.jspblog.model.User;

import lombok.Getter;

@Getter
public class PrincipalDetail implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2458763447874873323L;
	private User user;
	
	public PrincipalDetail(User user) {
		this.user = user;
	}

	// 계정의 비밀번호를 리턴한다.
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	// 계정의 이름을 리턴한다.
	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 계정이 만료되지 않았는 지 리턴한다. (true: 만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠겨있지 않았는 지 리턴한다. (true: 잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호가 만료되지 않았는 지 리턴한다. (true: 만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 활성화(사용가능)인 지 리턴한다. (true: 활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}

	// Returning authority
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(() -> {
			return "ROLE_" + user.getRole();
		});

		return collectors;
	}

}
