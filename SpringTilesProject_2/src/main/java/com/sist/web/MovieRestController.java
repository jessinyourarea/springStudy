package com.sist.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 searchMainDailyBoxOffice.do
 searchMainRealTicket.do 
 searchMainDailySeatTicket.do
 */
@RestController //자바스크립트나 데이터만 보낼때 사용하는 
public class MovieRestController {
	private String[] urls= {"","https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do",
			"https://www.kobis.or.kr/kobis/business/main/searchMainRealTicket.do",
			"https://www.kobis.or.kr/kobis/business/main/searchMainDailySeatTicket.do"};
	
	@GetMapping(value = "movie/movie_rank_vue_do", produces = "test/plain;charset=UTF-8")
	/*
	 	1. HTML 전송 => text/html
	 	2. XML 전송 => text/xml
	 	3. JSON 전송 => text/plain
	 	
	 	VO ==> {} ===> JSONObject
	 	List ==> [{},{},{},{}....] ====> JSONArray
	 	
	 	Rest==> React/Redux/Vue/AngularJS
	 */
	public String movie_rank(int no)
	{
		return "";
	}
}
