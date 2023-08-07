package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
	Spring: �ڹٶ��̺귯��
	--------
	 DI : Spring�� ���ؼ� ��ü ����~�Ҹ�
	                   -------
	                   �ʿ��� �����Ͱ� �ִ� ��쿡 �����͸� ���� (��������� �ʱ�ȭ)
	                   ������ �ʱ�ȭ
	                   ---------
	                   1. ����� �ʱ�ȭ => Ŭ������ ���� �ÿ� ������ ���� ���� ä���ִ� ���
	                      public class A
	                      {
	                        private String name="ȫ�浿";
	                      }
	                   2. ������ => ������ DI 
	                   3. setter�� �̿��ϴ� ��� => setter DI
	                      ------------------------------- XML�̿� , �ڹٸ� �̿�
     AOP : ���α׷� (�ٽ��ڵ�, ���� �ڵ�) 
                          ------ getConnection(), disConnection()
           => Ŭ�������� �������� ���Ǵ� �޼ҵ带 ��Ҵٰ� �ʿ��� �ñ⿡ �ڵ� ȣ���� �����ϵ���
           => Ʈ����� ���α׷�, LOG ���α׷�, ���� ���α׷� �� ��κ� AOP�� ����
     
     MVC : �� ���� �� (View/Model)
           Model: ������ ����(�ڹ�)
           View: ������ ��� ����
           Controller : ��û�� �ް�, �����͸� �����ϴ� ����
           -------------------------------------- �̹� ���̺귯���� ����
                   DispatcherServlet => TomCat�� ���� �ڵ� ����
                                        -------------web.xml����~
                   1) DispatcherServlet���
                   2) DispatcherServlet�� ã�� ���
                      <url-pattern>*.do</url-pattern>
                      <url-pattern>/</url-pattern>
                      => PathVariable admin/hong/1234
       ** ��û�� �޴� ��� (��û ������ ����)
           => request�ȿ� ��ܼ� ���´� => request.getParameter();
           ** request�� ����� ���� (IP,PORT) ������ �ִ�(���Ȼ� ����)
              => �������̸� ������� �ʴ´�
              => ����� ���� �޼ҵ带 ���鶧 �Ű������� �̿��ؼ� ������ �����ϸ�, DispatcherServlet�� ���� �Ű������� ä������ (request���)
              => JSP ������� ���� (Model)
       
        Model�� �ۼ�
        1) @Controller �����ؾ� �޸� �Ҵ��� �����ϴ�(�޼ҵ� ã�� ���)
        2) �޼ҵ�
           = ������: String, void
                  -------ȭ�� �̵��� ���õ� JSP����/�����̷�Ʈ ����
           = �Ű�����: JSP���� �����ϴ� ���尴ü ����
                    => HttpServletRequest , HttpServletResposne , HttpSession 
                    @GetMapping()
                    public String display(HttpSession session)
                    => VO����, String[] , �⺻��(int double boolean)
                    => List���� 
                    ** ������ �������
        3) ã��(�޼ҵ�)
           @GetMapping => Get������� ��û (default) => <a> ajax,axios ...
           @PostMapping => <form> , ajax, axios 
                                           ---- ajax��ü => Vue,React�� ��� axious ��� ����
           @RequestMapping => GET/POST�� ���ÿ� ó���� ����
        4) return => �ݵ�� JSP�� �ۼ�(Ȯ���� ������� �ʴ´�)
                     ��ȣ��(Redirect:) .do
        => MVC ���� ���
         1) ����� ��û => .do
         2) DispatcherServlet�� ��û�� �޴´�
         3) DispatcherServlet => HandlerMapping
                                 Ŭ������ ã�Ƽ� �޼ҵ带 ȣ���϶�� ����
                                 ������̼� (Get/PostMapping)
         4) Model���� ó�� ==> ����� ����(������)
         5) Model���� ó���� ����� DispatcherServlet�� �޴´�
         6) ViewResolver�� ����
            ------------ JSP�� ã�Ƽ� request�� �����ϴ� ����
         7) JSP���� request�� ��� �����͸� ���
         8) DispatcherServlet�� ���� ������ ȭ�� ����
 */
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class MainController {
	// ��ü �ּҸ� ������ ���� Ȯ��
	@Autowired
	private FoodDAO dao;
	
	// ����� ��û �� ó��
	@GetMapping("main/main.do")
	public String main_main(String cno,Model model,HttpServletRequest request)
	{
		if(cno==null)
			cno="1";
		
		Map map=new HashMap();
		map.put("cno", Integer.parseInt(cno));
		List<CategoryVO> list=dao.foodCategoryData(map);
		model.addAttribute("list", list);
		
		Cookie[] cookies=request.getCookies();
		List<FoodVO> cList=new ArrayList<FoodVO>();
		if(cookies!=null)
		{
			for(int i=cookies.length-1;i>=0;i--)
			{
				if(cookies[i].getName().startsWith("food_"))
				{
					String no=cookies[i].getValue();
					FoodVO vo=dao.foodDetailData(Integer.parseInt(no));
					cList.add(vo);
				}
			}
		}
		model.addAttribute("cList",cList);
		model.addAttribute("main_jsp","../main/home.jsp");
		return "main/main";
	}
	
}
