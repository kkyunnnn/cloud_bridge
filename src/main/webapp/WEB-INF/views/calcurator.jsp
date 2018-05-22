<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src='<c:url value="/assets/js/jquery-3.2.1.min.js"/>'></script>
</head>
<body>
	<h1>Calcurator</h1>
	<br>
	<input type="button" value="홈으로" onclick="javascript:location.href='/'">
	<br>
	<input type="text" name="disp" />
	<br>
	<input type="button" name="cal" value="7" />
	<input type="button" name="cal" value="8" />
	<input type="button" name="cal" value="9" />
	<br>
	<input type="button" name="cal" value="4" />
	<input type="button" name="cal" value="5" />
	<input type="button" name="cal" value="6" />
	<br>
	<input type="button" name="cal" value="1" />
	<input type="button" name="cal" value="2" />
	<input type="button" name="cal" value="3" />
	<br>
	<input type="button" name="cal2" value="+" />
	<input type="button" name="cal2" value="-" />
	<input type="button" name="cal2" value="*" />
	<input type="button" name="cal2" value="/" />
	<input type="button" name="enter" value="=" />
</body>
<script type="text/javascript">
	var tmp1;
	var tmp2;
	
	//window.onload = function() {
		var obj = document.getElementsByName('cal');
		var obj2 = document.getElementsByName('cal2');
		
		for(var i = 0; i < obj2.length; i++) {
			obj2[i].addEventListener('click', function(e) {
				var dispObj = document.getElementsByName('disp')[0];
				
				if(dispObj.value != "") {
					switch (this.value) {
					case '+':
						
						break;
					case '-':
						
						break;
					case '/':
						
						break;
					case '*':
						
						break;							
					default:
						break;
					}					
				}
			});
		}
		
		for(var i = 0; i < obj.length; i++) {
			obj[i].addEventListener('click', function(e) {
				var dispObj = document.getElementsByName('disp')[0];
				
				var dispValue = dispObj.value;
				dispValue = dispValue + "" + this.value;
				
				dispObj.value = dispValue;
			});
		}
	//}
</script>
</html>