package com.yhdc.jspblog.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhdc.jspblog.dto.RecoverMail;
import com.yhdc.jspblog.dto.RecoverPwd;
import com.yhdc.jspblog.model.User;
import com.yhdc.jspblog.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class SendEmailService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final String FROM_ADDRESS = "yhdchoi@gmail.com";
	private final JavaMailSender mailSender;

	// Temporary Password
	public String getTempPwd() {

		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '!',
				'$', '%', '*' };

		String tempPwd = "";

		int idx = 0;
		for (int i = 0; i < 10; i++) {
			idx = (int) (charSet.length * Math.random());
			tempPwd += charSet[idx];
		}

		return tempPwd;
	}

	// Write Email
	public Integer createMail(RecoverPwd recoverPwd) {

		String userName = recoverPwd.getUsername();
		String userEmail = recoverPwd.getEmail();
		String tempPwd = getTempPwd();
		log.info("userName: " + userName);
		log.info("userEmail: " + userEmail);
		log.info("tempPwd: " + tempPwd);

		RecoverMail recoverMail = new RecoverMail();

		recoverMail.setEmail(userEmail);
		recoverMail.setTitle("Hello " + userName + ". Your temporary password information.");
		recoverMail.setMessage("Hello " + userName + "! " + "Your temporary password is " + tempPwd);

		saveTempPwd(tempPwd, userEmail);

		sendEmail(recoverMail);

		return 1;
	}

	// Save TempPassword
	@Transactional
	public void saveTempPwd(String tempPwd, String userEmail) {
		log.info("SaveuserEmail: " + userEmail);
		log.info("SavetempPwd: " + tempPwd);

		User user = userRepository.findByEmail(userEmail).orElseThrow(() -> {
			return new IllegalArgumentException("THE USER DOES NOT EXIST.");
		});

		user.setPassword(bCryptPasswordEncoder.encode(tempPwd));
	}

	// Send Email
	public void sendEmail(RecoverMail recoverMail) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recoverMail.getEmail());
		message.setFrom(FROM_ADDRESS);
		message.setSubject(recoverMail.getTitle());
		message.setText(recoverMail.getMessage());
		log.info("Email message : " + message);

		mailSender.send(message);

		System.out.println("Recover email sent!");
	}
}
