<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>글쓰기</h1>
<form action="/board/write" method="post">
	<table>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="20" name="contents"></textarea> </td>
		</tr>		
	</table>
	<button>등록</button>
</form>