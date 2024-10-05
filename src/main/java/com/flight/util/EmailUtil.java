package com.flight.util;

import java.io.File;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendEmail(String toAddress, String filePath)
	{
		MimeMessage message=sender.createMimeMessage();
		try {
	 MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
	 messageHelper.setTo(toAddress);
	 messageHelper.setSubject("Email of Flight");
	 messageHelper.setText("please find the attached");
	 messageHelper.addAttachment("sendEmail",new File(filePath));
	 
	 sender.send(message);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
    
	}
	

}
