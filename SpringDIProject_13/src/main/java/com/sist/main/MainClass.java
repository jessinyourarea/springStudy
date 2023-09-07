package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.vo.*;
public class MainClass {
	public static void main(String[] args) {
		// �Ľ� => ��ϵ� Ŭ������ ������ �����̳ʷ� ����
		 ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		// DL(getBean,@Autowired) / DI
		 EmpDAO dao=(EmpDAO)app.getBean("dao");
		 List<EmpVO> list=dao.empDeptListData();
		 for(EmpVO vo:list)
		 {
			 System.out.println(vo.getEmpno()+" "
					          +vo.getEname()+" "
					          +vo.getJob()+" "
					          +vo.getDbday()+" "
					          +vo.getSal()+" "
					          +vo.getDvo().getDname()+" "
					          +vo.getDvo().getLoc());
		 }
		 System.out.println("===============================");
		 Scanner scan=new Scanner(System.in);
		 System.out.print("��� �Է�:");
		 int empno=scan.nextInt();
		 EmpVO vo=dao.empDeptDetailData(empno);
		 System.out.println("���:"+vo.getEmpno());
		 System.out.println("�̸�:"+vo.getEname());
		 System.out.println("����:"+vo.getDbday());
		 System.out.println("�޿�:"+vo.getSal());
		 System.out.println("�μ���:"+vo.getDvo().getDname());
		 System.out.println("�ٹ���:"+vo.getDvo().getLoc());
		 
	}
}
