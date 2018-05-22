<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
	table.type10 {
	    border-collapse: collapse;
	    text-align: left;
	    line-height: 1.5;
	    border-top: 1px solid #ccc;
	    border-bottom: 1px solid #ccc;
	    margin: 20px 10px;
	}
	table.type10 thead th {
	    width: 150px;
	    padding: 10px;
	    font-weight: bold;
	    vertical-align: top;
	    color: #fff;
	    background: #e7708d;
	    margin: 20px 10px;
	}
	table.type10 tbody th {
	    width: 150px;
	    padding: 10px;
	}
	table.type10 td {
	    width: 350px;
	    padding: 10px;
	    vertical-align: top;
	}
	table.type10 .even {
	    background: #fdf3f5;
	}
</style>
<script type="text/javascript">
	$(function() {
		$('tbody > tr:even').addClass('even');
	})
</script>
<table class="type10">
    <thead>
	    <tr>
	        <th scope="cols">번호</th>
	        <th scope="cols">제목</th>
	        <th scope="cols">내용</th>
	        <th scope="cols">등록일</th>
	    </tr>
    </thead>
    <tbody>
		<c:forEach var="item" items="${boardList }">
		    <tr>
		        <th scope="row">${item.idx }</th>
		        <th scope="row">${item.title }</th>
		        <th>${item.contents }</th>
		        <td>${item.insDate }</td>
		    </tr>
		</c:forEach>
    </tbody>
</table>

<a href="/board/write">글쓰기</a> <a href="/">홈</a>
