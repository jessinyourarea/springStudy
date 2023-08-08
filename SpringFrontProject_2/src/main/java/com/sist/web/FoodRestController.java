package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.FoodDAO;
import com.sist.vo.*;
import java.util.*;
@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping(value = "food/list_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_list_vue(String page)
	{
		String result="";
		try
		{
			if(page==null)
				page="1";
			int curpage=Integer.parseInt(page);
			Map map=new HashMap();
			map.put("start", (curpage*12)-11);
			map.put("end", curpage*12);
			List<FoodLocationVO> list=dao.foodListData(map);
			int totalpage=dao.foodTotalPage();
			
			// List => [] 변환 필요 ==> JSONArray
			// FoodLocationVO => {} ==> JSONObject
			// [{},{},{}, ...]
			JSONArray arr=new JSONArray();
			int i=0;
			// fno,name,poster,score
			/*
			 	{fno:1,name:"",poster:"",score:5.0} ...
			 */
			for(FoodLocationVO vo:list)
			{
				JSONObject obj=new JSONObject();
				obj.put("fno", vo.getFno());
				obj.put("name", vo.getName());
				obj.put("score", vo.getScore());
				String poster=vo.getPoster();
				poster=poster.substring(0,poster.indexOf("^"));
				poster=poster.replace("#", "&");
				obj.put("poster", poster);
				if(i==0)
				{
					obj.put("curpage", curpage);
					obj.put("totalpage",totalpage);
				}
				arr.add(obj);
				i++;
			}
			result=arr.toJSONString();
			
		}catch(Exception ex) {}
		return result;
	}
	
	/*
	   1. 일반 문자열로 보낼때 => NOID,NOPWD,OK => text/html로 보내준다
	   2. 데이터 묶음(JSON) => text/plain
	      List / VO
	             --- {} ==> 자바에서 JSONObject
	      ---[]         ==>       JSONArray
	      -----------------------------------> jackson (자동생성해주는 프로그램:Spring-Boot)
	   3. XML전송 => text/xml
	   
	 */
	@GetMapping(value = "food/find_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_find_vue(int page, String fd)
	{
		String result="";
		try
		{
			int curpage=page;
			Map map=new HashMap();
			map.put("start", (curpage*12)-11);
			map.put("end", curpage*12);
			map.put("address", fd);
			List<FoodLocationVO> list=dao.foodFindData(map);
			int totalpage=dao.foodFindTotalPage(fd);
			final int BLOCK=5;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage)
				endPage=totalpage;
			
			//JSON 변경
			int i=0;
			JSONArray arr=new JSONArray(); // list대신 사용하도록 만들어둠
			for(FoodLocationVO vo:list)
			{
				JSONObject obj=new JSONObject();
				obj.put("fno", vo.getFno());
				obj.put("name", vo.getName());
				obj.put("score", vo.getScore());
				String poster=vo.getPoster();
				poster=poster.substring(0,poster.indexOf("^"));
				poster=poster.replace("#", "&");
				obj.put("poster", poster);
				if(i==0)
				{
					obj.put("curpage", curpage);
					obj.put("totalpage", totalpage);
					obj.put("startPage", startPage);
					obj.put("endPage", endPage);
				}
				i++;
				arr.add(obj);
			}
			result=arr.toJSONString();
			
		}catch(Exception ex) {}
		return result;
	}
	
}
