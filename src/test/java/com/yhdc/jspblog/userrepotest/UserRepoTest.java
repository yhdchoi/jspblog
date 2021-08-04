package com.yhdc.jspblog.userrepotest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.yhdc.jspblog.model.User;
import com.yhdc.jspblog.model.enums.EnableType;
import com.yhdc.jspblog.model.enums.RoleType;
import com.yhdc.jspblog.repository.UserRepository;

@SpringBootTest
public class UserRepoTest {

	@Autowired
	private UserRepository userRepository;

//	@Test
//	public void insert() {
//
//		User user = User.builder().username("Daniel").password(new BCryptPasswordEncoder().encode("qwer"))
//				.email("yhdchoi@naver.com").role(RoleType.ADMIN).enable(EnableType.ENABLE).build();
//
//		userRepository.save(user);
//
//	}
	
	@Test
	public void insertUser() {

		User user = User.builder().username("User").password(new BCryptPasswordEncoder().encode("user"))
				.email("abc@naver.com").role(RoleType.USER).enable(EnableType.ENABLE).build();

		userRepository.save(user);

	}
}