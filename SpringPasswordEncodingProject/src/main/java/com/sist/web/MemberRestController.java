package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
import com.sist.vo.*;
// security 5 ==> 부터는 꼭 BCryptPasswordEncoder를 써야한다
@RestController
public class MemberRestController {
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private MemberDAO dao;
	
	@PostMapping(value = "member/join_ok.do", produces = "text/plain;charset=UTF-8")
	public String member_join(MemberVO vo)
	{
		System.out.println("id:"+vo.getId()+" "
				           +"pwd:"+vo.getPwd()+" "
				           +"name:"+vo.getName()+" "
				           +"gender:"+vo.getGender());
		String result="";
		try
		{
			String en=encoder.encode(vo.getPwd()); // 암호화
			vo.setPwd(en);
			dao.signUp(vo);
			result="YES";
		}catch(Exception ex)
		{
			result="NO";
			ex.printStackTrace();
		}
		return result;
	}
	
	@PostMapping(value = "member/login_ok.do", produces = "text/plain;charset=UTF-8")
	// 매개변수로 세션을 선언한다 => DispatcherServlet에 의해 값을 주입
	// 필요한 객체가 있으면 => 매개변수를 통해서 값을 가져온다
	// 매개변수는 순서와 상관없다
	// 사용자 전송 (요청) => request.getParameter()
	// 받을 수 있는 클래스 : 내장 객체는 가능, Model(전송 객체) => forward에서만 사용
	// sendRedirect => RedirectAttributes
	public String member_login_ok(String id, String pwd, HttpSession session)
	{
		String result="";
		int count=dao.memberIdCheck(id);
		if(count==0)
		{
			result="NOID";
		}
		else
		{
			MemberVO vo=dao.memberLogin(id);
			if(encoder.matches(pwd, vo.getPwd())) //로긴 시도 비번과 db에 인코딩된 pwd가 같은지 (비교)
			{
				// 로그인
				result="OK";
				
				// 세션에 저장
				session.setAttribute("id", id);
				session.setAttribute("name", vo.getName());
				session.setAttribute("gender", vo.getGender());
				
			}
			else
			{ 
				// 비밀번호가 틀린 상태 => 같은 값인데 암호화는 다르다
				result="NOPWD";
			}
		}
		try
		{
			
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return result;
	}
}
