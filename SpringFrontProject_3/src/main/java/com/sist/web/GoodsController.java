package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
	�ڹ�
	 = �������� / ���� / ������ / ��� / �迭(1��)
	 = ��ü���� ���α׷� (Ŭ����/��ü) ��ü���� 3�� ���(ĸ��ȭ,���,����,������)
	    *** ĸ��ȭ VS ����ȭ 
	    *** ��� VS ����
	    *** �������̵� VS �����ε�
	 = �߻�Ŭ����/�������̽�
	    *** �߻�Ŭ���� VS �������̽�
	    *** �������̽��� ������?
	 = ����ó�� 
	    *** ����ó�� ������ ��������? : ������ ������ �����ϴ� + ���α׷��� ������� �ʵ��� �ϱ� ����
	 = ���̺귯�� (java.lang, java.util(
	   = Collection, Generics
	    *** �ݷ��ǰ� ���׸���
	   = IO
	����Ŭ
	 = DQL : SELECT + JOIN/SubQuery
	    *** JOIN�� ������ �����Ͻÿ�.
	    *** ���������� ������ �����Ͻÿ�.
	 = DML : INSERT, UPDATE, DELETE
	 = DDL : CREATE, ALTER, DROP, TRUNCATE + ��������
	    *** �������� �̶�?
	 = TCL : COMMIT, ROLLBACK
	 = PL/SQL (�⺻������ ���ν��� ����ϴ� ����)
	    *** ���ν��� VS Ʈ����
	 = JDBC (DBCP/ORM(MyBatis,JPA))
	    *** DAO VS Service
	HTML5/CSS
	    *** Get VS Post
	JavaScript => ���� ����(let,const), ���/������
	           => �Լ�
	           => �̺�Ʈ
	           => �±� ���� (DOM)
	           => ���̺귯�� (Jquery,VueJS,React)
	    *** var VS let VS const 
	    *** Ŭ���� 
	    *** prototype 
	    *** VueJS VS React
	JSP : ������(page, taglib), ���尴ü(request,response,Session,application)
	      actionTag(<jsp:include>)
	      tagLib (<c:~~> , EL(${}))
	      MVC 
	    *** MVC ������ �����Ͻÿ�. (+���۰���)
	Spring : DI, AOP, MVC 
	    *** DI
	    *** AOP
	         option(WebSocket,task,security,spring-boot)
	AWS : ȣ����
 */
@Controller
public class GoodsController {
	@GetMapping("goods/list.do")
	public String goods_list()
	{
		return "goods/list";
	}
	
	@GetMapping("goods/detail.do")
	public String goods_detail(int no, Model model)
	{
		model.addAttribute("no",no);
		return "goods/detail";
	}
	
}
