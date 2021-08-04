package com.yhdc.jspblog.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.yhdc.jspblog.dto.RecoverMail;
import com.yhdc.jspblog.dto.RecoverPwd;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SendEmailService {
	
	private final String FROM_ADDRESS = "yhdchoi@gmail.com";
	private final JavaMailSender mailSender;
	private final UserService userService;
	
	
	
	public String getTempPwd() {
		
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '!', '$', '%', '*' };

        String tempPwd = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            tempPwd += charSet[idx];
        }		
		
		return tempPwd;
	}
	

	public RecoverMail createMail(RecoverPwd recoverPwd) {
		
		String userName = recoverPwd.getUsername();
		String userEmail = recoverPwd.getEmail();
		
		String tempPwd = getTempPwd();
		RecoverMail mail = new RecoverMail();
		
		mail.setMessage(userEmail);
		mail.setTitle("Hello " + userName + ". Your temporary password information.");
		mail.setMessage("Your temporary password is " + tempPwd);
		
		userService.saveTempPwd(tempPwd, userEmail);
		
		return mail;
	}
	
	
	public void sendEmail(RecoverMail recoverMail) {
		
		System.out.println("Recover email sent!");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recoverMail.getEmail());
        message.setFrom(FROM_ADDRESS);
        message.setSubject(recoverMail.getTitle());
        message.setText(recoverMail.getMessage());

        mailSender.send(message);		
	}
	
	
}
