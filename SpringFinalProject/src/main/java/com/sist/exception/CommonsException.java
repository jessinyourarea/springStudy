package com.sist.exception;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class CommonsException {
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException ex)
	{
		System.out.println("===================== RuntimeException 발생 ===================");
		ex.printStackTrace();
		System.out.println("==============================================================");
	}
	
	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException ex)
	{
		System.out.println("===================== SQLException 발생 ===================");
		ex.printStackTrace();
		System.out.println("==============================================================");
	}
	
	@ExceptionHandler(Exception.class)
	public void Exception(Exception ex)
	{
		System.out.println("===================== Exception 발생 ===================");
		ex.printStackTrace();
		System.out.println("==============================================================");
	}
	
	
	// IOException , SQLException , Exception
}
