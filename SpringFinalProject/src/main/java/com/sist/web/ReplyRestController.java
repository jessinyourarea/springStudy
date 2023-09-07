package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.ReplyVO;

import java.util.*;

import javax.servlet.http.HttpSession;
@RestController
public class ReplyRestController {
	@Autowired
	private ReplyDAO dao;
	
	public String reply_list_data(int fno)
	{
		String json="";
		try
		{
			List<ReplyVO> list=dao.replyListData(fno);
			ObjectMapper mapper=new ObjectMapper();
			json=mapper.writeValueAsString(list);
		}catch(Exception ex) {}
		return json;
	}
	
	@GetMapping(value = "reply/reply_read_vue.do", produces = "text/plain;charset=UTF-8")
	public String reply_read(int fno)
	{
		return reply_list_data(fno);
	}
	
	@PostMapping(value = "reply/reply_insert_vue.do", produces="text/plain;charset=UTF-8")
	public String reply_insert(ReplyVO vo, HttpSession session)
	{
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		
		dao.replyInsert(vo);
		
		return "";
	}
}
