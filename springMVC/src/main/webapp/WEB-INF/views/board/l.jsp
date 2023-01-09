<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="edu.study.vo.BoardVO" %>
<%

	List<BoardVO> list = (List<BoardVO>)request.getAttribute("datalist");

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>board/list 페이지</h2>
	<table border="1">
	<%-- 
	<%
		for(BoardVO vo : list){
			%>
			<tr>
				<td><%=vo.getTitle() %></td>
				<td><%=vo.getWriter() %></td>
				<td><%=vo.getContent() %></td>
			</tr>
			<%
		}
	%> --%>
	</table>
	
	<table border="1">
	<c:forEach items="${datalist}" var="vo">
		<tr>
			<td>${vo.bidx}</td>
			<td><a href="view.do?bidx=${vo.bidx}">${vo.title}</a></td>
			<td>${vo.wdate}</td>
		</tr>
	</c:forEach>
	
	<c:if test="${login != null }">
		<a href="<%= request.getContextPath() %>/board/w.do">글쓰기</a>
	</c:if>
	</table>
	
</body>
</html>











