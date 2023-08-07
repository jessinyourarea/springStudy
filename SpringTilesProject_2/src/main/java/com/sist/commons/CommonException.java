package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.sql.*;

@ControllerAdvice // ����ó���� �ѹ��� ó���Ҷ� ���(Controller���� �߻��ϴ� ���� ���)
public class CommonException {
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException ex)
	{
		System.out.println("====== RuntimeException =====");
		ex.printStackTrace();
		System.out.println("=============================");
	}
	@ExceptionHandler(SQLException.class)
	public void SQLException(SQLException ex)
	{
		System.out.println("====== SQLException =====");
		ex.printStackTrace();
		System.out.println("=============================");
	}
	
	@ExceptionHandler(IOException.class)
	public void ioException(IOException ex)
	{
		System.out.println("====== IOException =====");
		ex.printStackTrace();
		System.out.println("=============================");
	}
}
