<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <h2>Uploaded File Details</h2> 
                    <input type="button" value="뒤로가기" onclick="javascript:location.href='/uploadTestImgToBinary'">
                    <input type="button" value="홈으로" onclick="javascript:location.href='/'">
                        <div class="row" style="border:1px solid #ccc; margin:5px;">
                            <div class="col-md-4">
                                <%-- <img src="/assets/uploadfile/<c:out value="${fileInfo.name}" />"> --%>
                                <img src="data:image/gif;base64,${fileInfo }" >
                            </div>
                        </div>
                </div>
            </div>
        </div>
        ${binary }
    </body>
</html>