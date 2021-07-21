package com.yhdc.jspblog.userrepotest;

import java.util.stream.IntStream;

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

	@Test
	public void insert() {
		IntStream.rangeClosed(1, 10).forEach(i -> {

			User user = User.builder().username("USER" + i).password(new BCryptPasswordEncoder().encode("password" + i))
					.email("user" + i + "@aaa.com").role(RoleType.USER).enable(EnableType.ENABLE).build();

			userRepository.save(user);
		});
	}
}