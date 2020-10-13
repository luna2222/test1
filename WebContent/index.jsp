<%@page import="common.EmpVo"%>
<%@page import="java.util.List"%>
<%@page import="common.JDBCTemplate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<!-- 다른 패키지에 있으므로 임포트 시켜줘야 사용가능함. -->
<%
JDBCTemplate jdbcTemp = new JDBCTemplate();
List<EmpVo> emplist = jdbcTemp.getEmps();// getEmps ()은 db 연결하고 select * from emp라는 sql문의 실행 결과를 리턴해준다.
%>
<p> EMP 목록</p>
<table border="2px">
<tr>
<td>empno</td>
<td>ename</td>
<td>job</td>
</tr>
<%
for(int i=0; i<emplist.size(); i++){
//지금부터 자바 코드 형태를  넣을수 있습니다.+jsp에 형태코드를 넣어주면 된다
//주석도 자바주석을 사용
	EmpVo empvo = emplist.get(i);
%>
<tr>
<td><%=empvo.getEmpno()%></td>
<td><%=empvo.getEname()%></td>
<td><%=empvo.getJob()%></td>
</tr>
 <% 
    }
   %>
</table>
</body>
</html>