package com.lec.ch19.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.lec.ch19.dao.MemberDao;
import com.lec.ch19.dto.MemberDto;

@Repository
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Override
	public int idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}

	@Override
	public int joinMember(final MemberDto memberDto, HttpSession httpSession) {
		//member.getMname()에게 메일보내기, member insert하기, 세션에 추가하기
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = "<div id=\"wrap\" style=\"width:500px; margin: 0 auto;\">\n" + 
					"		<h1 style=\"color:blue;\">"+memberDto.getMname()+"님 회원가입 감사합니다.</h1>\n" + 
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
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(memberDto.getMmail()));
				mimeMessage.setFrom(new InternetAddress("spaceny10@gmail.com")); // 보내는 사람
				mimeMessage.setSubject("[HTML 가입인사]"+memberDto.getMname()+"님 회원가입 감사합니다.");
				mimeMessage.setText(content, "utf-8", "html");
				
			}
		};
		mailSender.send(message);
		httpSession.setAttribute("mid", memberDto.getMid());// 세션에 id 속성 추가
	
		 
		return memberDao.joinMember(memberDto) ; // member insert
		
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession httpSession) {
		String result = "로그인 성공";
		MemberDto memberDto = memberDao.getDetailMember(mid);
		if(memberDto == null) {
			result = "유효하지 않은 아이디입니다.";
		}else if (!mpw.equals(memberDto.getMpw())) {
			result = "비밀번호가 맞지 않습니다.";
		} else {
			httpSession.setAttribute("member", memberDto);
			httpSession.setAttribute("mid", mid);
			result = "로그인 성공";
		}
		return result;
	}

	@Override
	public MemberDto getDetailMember(String mid) {
		
		return memberDao.getDetailMember(mid);
	}

	@Override
	public int modifyMember(MemberDto memberDto) { 
		return memberDao.modifyMember(memberDto);
	}

}
