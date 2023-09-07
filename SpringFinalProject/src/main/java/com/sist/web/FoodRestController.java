package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
@RestController
public class FoodRestController {
	@Autowired
	private FoodDAO dao;
	
	@Autowired
	private ReplyDAO rdao;
	
	@GetMapping(value = "food/category_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_category() throws Exception
	{
		List<CategoryVO> list=dao.foodCategoryListData();
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	
	@GetMapping(value = "food/category_info_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_category_info(int cno) throws Exception {
		CategoryVO vo=dao.foodCategoryInfoData(cno);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}

	@GetMapping(value = "food/food_list_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_list_vue(int cno) throws Exception {
		
		List<FoodVO> list=dao.foodListData(cno);
		for(FoodVO vo:list)
		{
			String poster=vo.getPoster().substring(0,vo.getPoster().indexOf("^"));
			poster=poster.replace("#", "^");
			vo.setPoster(poster);
			String addr=vo.getAddress().substring(0,vo.getAddress().indexOf("지번"));
			vo.setAddress(addr);
		}
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	
	@GetMapping(value = "food/food_find_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_find(int page, String column, String fd) throws Exception {
		Map map=new HashMap();
		map.put("column", column);
		map.put("fd", fd);
		int rowSize=20;
		int start=(page-1)*rowSize+1;
		int end=rowSize*page;
		map.put("start", start);
		map.put("end", end);
		List<FoodVO> list=dao.foodFindData(map);
		
		for(FoodVO vo:list) {
			String poster=vo.getPoster();
			poster=poster.substring(0,poster.indexOf("^"));
			poster=poster.replace("#", "^");
			vo.setPoster(poster);
			
			ReplyVO rvo=rdao.foodReplyData(vo.getFno());
			
		}
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	
	@GetMapping(value = "food/page_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_page_vue(int page, String column, String fd) throws Exception{
		
		Map map=new HashMap();
		map.put("column", column);
		map.put("fd", fd);
		int totalpage=dao.foodFindTotalPage(map);
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		PageVO vo=new PageVO();
		vo.setCurpage(page);
		vo.setTotalpage(totalpage);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}
	
	@GetMapping(value = "food/food_detail_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_detail_vue(int fno) throws Exception {
		
		FoodVO vo=dao.foodDetailData(fno);
		String addr=vo.getAddress().substring(0,vo.getAddress().indexOf("지번"));
		vo.setAddress(addr.trim());
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}

	@GetMapping(value = "food/food_house_detail_vue.do", produces = "text/plain;charset=UTF-8")
	public String food_house_detail(int fno) throws Exception{
		FoodVO vo=dao.foodDetailHouseData(fno);
		String addr=vo.getAddress();
		addr=addr.substring(0,addr.indexOf("지번"));
		vo.setAddress(addr.trim());
		String menu=vo.getMenu();
		if(!menu.equals("no"))
		{
			menu=menu.substring(0,menu.lastIndexOf("원"));
			vo.setMenu(menu);
		}
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}

	@GetMapping(value = "reply/reply_insert_vue.do", produces = "text/plain;charset=UTF-8")
	public String reply_insert(ReplyVO vo,HttpSession session)
	{
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		vo.setId(id);
		vo.setName(name);
		return "";
	}

	@GetMapping(value = "reply/reply_delete_vue.do", produces = "text/plain;charset=UTF-8")
	public String reply_delete(ReplyVO vo, HttpSession session)
	{
		
		return "";
	}

}











