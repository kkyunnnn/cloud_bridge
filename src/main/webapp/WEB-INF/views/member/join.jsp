<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/member/join" method="post">
		아이디 : <input type="text" name="id" > <br>
		이름 : <input type="text" name="name" > <br>
		비밀번호 : <input type="password" name="pwd" > <br>
		나이 : <input type="text" name="age" > <br>
		<button>가입</button>
	</form>
</body>
</html>