package com.sist.web;

import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import java.io.*;
import java.net.*;
@org.springframework.web.bind.annotation.RestController
public class RestController {
	private String[] urls= {"","https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do",
			"https://www.kobis.or.kr/kobis/business/main/searchMainRealTicket.do",
			"https://www.kobis.or.kr/kobis/business/main/searchMainDailySeatTicket.do"};
	@GetMapping(value="movie/movie_vue.do",produces="text/plain;charset=UTF-8")
	public String movie_vue(int no)
	{
		String result="";
		try {
			URL url=new URL(urls[no]);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection(); // ����Ʈ ����
			StringBuffer sb=new StringBuffer();
			if(conn!=null) // ����Ʈ ���� ��
			{
				BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
				while(true) {
					String line=in.readLine();
					if(line==null)
						break;
					sb.append(line);
				}
				in.close();
			}
			result=sb.toString();
			
		} catch (Exception e) {}
		return result;
	}
}
