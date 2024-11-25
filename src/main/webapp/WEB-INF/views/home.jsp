<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>
<P>  The time on the server is ${serverTime}. </P>
<li><a href ="/board/list">게시판 리스트</a>
<li><a href ="/uploadForm">파일업로드(폼방식)</a>
<li><a href ="/uploadAjax">파일업로드(Ajax방식)</a>
</body>
</html>
