package com.sist.mapper2;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Select;
public interface EmpDeptMapper {
	/*
	 <resultMap type="com.sist.vo.EmpVO" id="empMap">
      <result column="dname" property="dvo.dname"/>
      <result column="loc" property="dvo.loc"/>
    </resultMap>
	
	 */
	@Results({
		@Result(column = "dname", property = "dvo.dname"),
		@Result(column = "loc", property = "dvo.loc")
	})
	
	/*
	  <select id="empDeptListData" resultMap="empMap">
       SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal,dname,loc
      FROM emp,dept WHERE emp.deptno=dept.deptno
      ORDER BY sal DESC
    </select>
	
	 */
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal,dname,loc "
			+ "FROM emp,dept WHERE emp.deptno=dept.deptno "
			+ "ORDER BY sal DESC")
	public List<EmpVO> empDeptListData();
	
	@Results({
		@Result(column = "dname", property = "dvo.dname"),
		@Result(column = "loc", property = "dvo.loc")
	})
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal,dname,loc "
			+ "FROM emp,dept WHERE emp.deptno=dept.deptno "
			+ "AND empno=#{empno}")
	public EmpVO empDeptDetailData(int empno);
	
}
