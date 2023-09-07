package com.sist.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*
	<인터셉터를 보내면>                     여기서 인터셉트(preHandle)        인터셉터 한번더(postHandle)               인터셉터(afterCompletion)
	1. 요청 (.do) => DispatcherServlet =============> HandlerMapping  ====================> ViewResolver  ==========================> JSP
			                                        @Controller/@RestController            return값을 받아서 화면을 변경해주는 위치
			                                        => @GetMapping,@PostMapping
			                                        
		Spring 
		  = setting : AOP/DO => 클래스 등록
		  = ORM (Mybatis) 
		     1) XML
		     2) Annotation
		     3) XML + Annotation
		  = Transaction
		  ------------------
		  = WebSocket
		  = Security
		  = Task
		  -----------------------
		  = MVC
		  
 */
public class AutoInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle: ...");
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle: ...");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion: ... ");
		super.afterCompletion(request, response, handler, ex);
		
	}
	
}
