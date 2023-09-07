package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.RecipeDAO;

import java.text.DecimalFormat;
import java.util.*;
@RestController
public class RecipeRestController {
	@Autowired
	private RecipeDAO dao;
	
	@GetMapping(value = "recipe/recipe_list_vue.do", produces = "text/plain;charset=UTF-8")
	public String recipe_list_vue(int page) throws Exception
	{
		Map map=new HashMap();
		int rowSize=20;
		int start=(page-1)*rowSize+1;
		int end=page*rowSize;
		map.put("start", start);
		map.put("end", end);
		List<RecipeVO> list=dao.recipelistData(map);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	
	@GetMapping(value = "recipe/page_list_vue.do", produces = "text/plain;charset=UTF-8")
	public String recipe_page_list(int page) throws Exception
	{
		int count=dao.recipeRowCount();
		int totalpage=(int)(Math.ceil(20.0));
		DecimalFormat df=new DecimalFormat("###,###,###");
		String strCount=df.format(count);
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		PageVO vo=new PageVO();
		vo.setTotalpage(totalpage);
		vo.setCurpage(page);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		vo.setCount(strCount);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}
	
	@GetMapping(value = "recipe/chef_list_vue.do", produces = "text/plain;charset=UTF-8")
	public String chef_list_vue(int page) throws Exception{
		
		Map map=new HashMap();
		int rowSize=20;
		int start=(page-1)*rowSize+1;
		int end=page*rowSize;
		map.put("start", start);
		map.put("end", end);
		List<ChefVO> list=dao.chefListData(map);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	
	@GetMapping(value = "recipe/chef_page_list_vue.do", produces = "text/plain;charset=UTF-8")
	public String chef_page_list(int page) throws Exception
	{
		int totalpage=dao.chefTotalPage();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		PageVO vo=new PageVO();
		vo.setTotalpage(totalpage);
		vo.setCurpage(page);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}
	
	@GetMapping(value = "recipe/chef_info_vue.do", produces = "text/plain;charset=UTF-8")
	public String chef_detail_vue(String chef) throws Exception{
		
		ChefVO vo=dao.chefInfoData(chef);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}
	
	@PostMapping(value = "recipe/chef_find_vue.do", produces = "text/plain;charset=UTF-8")
	public String chef_find_vue(int page,String chef,String fd) throws Exception
	{
		Map map=new HashMap();
		
		int rowSize=20;
		int start=(page-1)*rowSize+1;
		int end=page*rowSize;
		map.put("start", start);
		map.put("end", end);
		map.put("fd", fd);
		map.put("chef",chef);

		List<RecipeVO> list=dao.chefFindData(map);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);//Spring-Boot (Default)
		return json;
	}
	
	@GetMapping(value = "recipe/page_info_vue.do", produces = "text/plain;charset=UTF-8")
	public String page_info(int page, String chef, String fd) throws Exception{
		
		if(fd==null || fd.equals(""))
		{
			fd="all";
		}
		Map map=new HashMap();
		map.put("chef", chef);
		map.put("fd", fd);
		int count=dao.chefFindCount(map);

		int totalpage=(int)(Math.ceil(count/20.0));
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		PageVO vo=new PageVO();
		vo.setTotalpage(totalpage);
		vo.setCurpage(page);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		
		return json;
	}
	
	
}
