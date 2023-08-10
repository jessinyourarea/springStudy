package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
	자바
	 = 데이터형 / 변수 / 연산자 / 제어문 / 배열(1차)
	 = 객체지향 프로그램 (클래스/객체) 객체지향 3대 요소(캡슐화,상속,포함,다형성)
	    *** 캡슐화 VS 은닉화 
	    *** 상속 VS 포함
	    *** 오버라이딩 VS 오버로딩
	 = 추상클래스/인터페이스
	    *** 추상클래스 VS 인터페이스
	    *** 인터페이스의 장점은?
	 = 예외처리 
	    *** 예외처리 목적이 무엇이죠? : 사전에 에러를 방지하는 + 프로그램에 종료되지 않도록 하기 위함
	 = 라이브러리 (java.lang, java.util(
	   = Collection, Generics
	    *** 콜렉션과 제네릭스
	   = IO
	오라클
	 = DQL : SELECT + JOIN/SubQuery
	    *** JOIN의 종류를 설명하시오.
	    *** 서브쿼리의 종류를 설명하시오.
	 = DML : INSERT, UPDATE, DELETE
	 = DDL : CREATE, ALTER, DROP, TRUNCATE + 제약조건
	    *** 제약조건 이란?
	 = TCL : COMMIT, ROLLBACK
	 = PL/SQL (기본적으로 프로시저 사용하는 정도)
	    *** 프로시저 VS 트리거
	 = JDBC (DBCP/ORM(MyBatis,JPA))
	    *** DAO VS Service
	HTML5/CSS
	    *** Get VS Post
	JavaScript => 변수 사용법(let,const), 제어문/연산자
	           => 함수
	           => 이벤트
	           => 태그 제어 (DOM)
	           => 라이브러리 (Jquery,VueJS,React)
	    *** var VS let VS const 
	    *** 클로저 
	    *** prototype 
	    *** VueJS VS React
	JSP : 지시자(page, taglib), 내장객체(request,response,Session,application)
	      actionTag(<jsp:include>)
	      tagLib (<c:~~> , EL(${}))
	      MVC 
	    *** MVC 구조를 설명하시오. (+동작과정)
	Spring : DI, AOP, MVC 
	    *** DI
	    *** AOP
	         option(WebSocket,task,security,spring-boot)
	AWS : 호스팅
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
