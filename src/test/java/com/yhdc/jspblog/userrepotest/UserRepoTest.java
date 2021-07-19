package com.yhdc.jspblog.userrepotest;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yhdc.jspblog.model.EnableType;
import com.yhdc.jspblog.model.RoleType;
import com.yhdc.jspblog.model.User;
import com.yhdc.jspblog.repository.UserRepository;

@SpringBootTest
public class UserRepoTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void insert() {
		IntStream.rangeClosed(1, 50).forEach(i -> {

			User user = User.builder().username("USER" + i).password("password" + i)
					.email("user" + i + "@aaa.com").role(RoleType.USER).enable(EnableType.ENABLE).build();

			userRepository.save(user);
		});
	}
}