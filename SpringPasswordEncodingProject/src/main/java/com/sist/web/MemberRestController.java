package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
import com.sist.vo.*;
// security 5 ==> ���ʹ� �� BCryptPasswordEncoder�� ����Ѵ�
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
			String en=encoder.encode(vo.getPwd()); // ��ȣȭ
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
	// �Ű������� ������ �����Ѵ� => DispatcherServlet�� ���� ���� ����
	// �ʿ��� ��ü�� ������ => �Ű������� ���ؼ� ���� �����´�
	// �Ű������� ������ �������
	// ����� ���� (��û) => request.getParameter()
	// ���� �� �ִ� Ŭ���� : ���� ��ü�� ����, Model(���� ��ü) => forward������ ���
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
			if(encoder.matches(pwd, vo.getPwd())) //�α� �õ� ����� db�� ���ڵ��� pwd�� ������ (��)
			{
				// �α���
				result="OK";
				
				// ���ǿ� ����
				session.setAttribute("id", id);
				session.setAttribute("name", vo.getName());
				session.setAttribute("gender", vo.getGender());
				
			}
			else
			{ 
				// ��й�ȣ�� Ʋ�� ���� => ���� ���ε� ��ȣȭ�� �ٸ���
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
