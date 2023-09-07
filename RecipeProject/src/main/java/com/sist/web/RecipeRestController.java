package com.sist.web;

import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.service.*;
import com.sist.vo.*;

@RestController
public class RecipeRestController {
	@Autowired
	private RecipeService service;
	
	@GetMapping(value = "recipe/list_vue.do", produces = "application/json;charset=UTF-8")
	public String recipe_list_vue(int page)
	{
		String result="";
		try
		{
			int curpage=page;
			Map map=new HashMap();
			map.put("start", (curpage*12)-11);
			map.put("end", curpage*12);
			List<RecipeVO> list=service.recipeListData(map);
			int totalpage=service.recipeTotalPage();
			
			final int BLOCK=10;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage)
				endPage=totalpage;
			
			JSONObject obj=new JSONObject();
			JSONArray arr=new JSONArray();

			for(RecipeVO vo:list)
			{
				Map<String,Object> mvo=new HashMap<String,Object>();
				mvo.put("no", vo.getNo());
				mvo.put("title", vo.getTitle());
				mvo.put("poster", vo.getPoster());
				mvo.put("chef", vo.getChef());
				
				JSONObject jvo=new JSONObject(mvo);
				arr.add(jvo);
			}
			
			obj.put("list", arr);
			obj.put("curpage", curpage);
			obj.put("totalpage", totalpage);
			obj.put("startPage", startPage);
			obj.put("endPage", endPage);
			
			result=obj.toJSONString();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return result;
	}
}
