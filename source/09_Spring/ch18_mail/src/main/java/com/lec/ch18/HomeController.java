package com.lec.ch18;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class HomeController { 
	@Autowired
	private JavaMailSenderImpl mailSender;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "join";
	}
	@RequestMapping(value = "textMail", method = RequestMethod.GET)
	public String textMail(String name, String email, Model model) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("spaceny10@gmail.com"); // 관리자 메일 주소(보내는 사람)
		message.setTo(email);// 받는 사람 메일
		message.setSubject("[TEXT 가입인사]"+name+"님 회원가입 감사합니다.");
		String content = name + "님 회원가입 감사합니다\n <h1>태그 안먹음</h1>";
		message.setText(content);// 메일 본문내용
		mailSender.send(message); // 메일보내기
		model.addAttribute("mailSendResult", "TEXT메일이 전송되었습니다.");
		
		return "sendResult";
	}
	@RequestMapping(value = "htmlMail", method = RequestMethod.GET)
	public String htmlMail(final String name, final String email, Model model) {
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = "<div id=\"wrap\" style=\"width:500px; margin: 0 auto;\">\n" + 
					"		<h1 style=\"color:blue;\">"+name+"님 회원가입 감사합니다.</h1>\n" + 
					"	</div>\n" + 
					"	<div id=\"wrap\" style=\"width:500px; margin: 0 auto;\">\n" + 
					"		<p style=\"color:red;\">아무개 사이트에서 쓰이는 감사 쿠폰을 발송해드립니다..</p>\n" + 
					"		<p>\n" + 
					"			<img alt=\"쿠폰\" src=\"http://localhost:8090/ch18/resources/coupon.jpg\">\n" + 
					"		</p>\n" + 
					"	\n" + 
					"	<p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
					"	<p style=\"color:blue;\">파란 글씨 부분</p>\n" + 
					"	<p style=\"color:green;\">초록 글씨 부분</p>\n" + 
					"	</div>\n" + 
					"	<img src=\"https://image.fmkorea.com/files/attach/new2/20220725/4366334379/3105355204/4853236109/803bc9aa75916bf2112c3fe3b1da0a4d.jpg\">\n" + 
					"	\n" + 
					"	<br>\n" + 
					"	<hr>\n" + 
					"	<p>서울시 무슨구 무슨동 무슨로 1111-1111</p>";
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// 보내는 메일, 받는 메일, 메일 제목, utf-8
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				mimeMessage.setFrom(new InternetAddress("spaceny10@gmail.com")); // 보내는 사람
				mimeMessage.setSubject("[HTML 가입인사]"+name+"님 회원가입 감사합니다.");
				mimeMessage.setText(content, "utf-8", "html");
				
			}
		};
		mailSender.send(message);
		model.addAttribute("mailSendResult", "HTML메일이 전송되었습니다.");
		
		return "sendResult";
	}
	
}
