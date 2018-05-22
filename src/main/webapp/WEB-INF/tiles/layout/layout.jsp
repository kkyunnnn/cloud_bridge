<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href='<c:url value="/assets/css/bootstrap.min.css"/>' />
<script type="text/javascript" src='<c:url value="/assets/js/jquery-3.2.1.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/assets/js/bootstrap.min.js"/>'></script>
<link rel="stylesheet" href='<c:url value="/assets/css/common.css"/>' />
</head>

<body>
	<!-- header S -->
	<tiles:insertAttribute name="header" />
	<!-- header E -->
	
	<div class="container-fluid">
		<div class="row content">
			<!-- left-menu S -->
			<tiles:insertAttribute name="left-menu" />
			<!-- left-menu E -->
			<div class="col-sm-9">
				<!-- contents S -->
				<tiles:insertAttribute name="contents" />
				<!-- contents E -->
			</div>
		</div>
	</div>
	
	<!-- footer S -->
	<tiles:insertAttribute name="footer" />
	<!-- footer E -->
</body>
</html>