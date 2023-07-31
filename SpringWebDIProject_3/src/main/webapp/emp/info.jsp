<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
  margin: 0px auto;
  width:800px;
}
</style>
</head>
<body>
  <div class="container">
    <h1 class="text-center">사원 정보</h1>
    <div class="row">
      <table class="table">
        <tr>
          <th width=15%>사번</th>
          <th width=20%>이름</th>
          <th width=30%>직위</th>
          <th width=20%>입사일</th>
          <th width=15%>급여</th>
        </tr>
        
      <c:forEach var="vo" items="${list}" }>
        <tr>
          <td width=15%>${vo.empno }</td>
          <td width=20%>${vo.ename }</td>
          <td width=30%>${vo.job }</td>
          <td width=20%>${vo.dbday }</td>
          <td width=15%>${vo.pay }</td>
        </tr>
      </c:forEach>
        <tr>
          <td class="text-right">
            <button class="btn btn-sm btn-danger">목록</button>
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>