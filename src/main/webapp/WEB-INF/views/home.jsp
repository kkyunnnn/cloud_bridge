<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<script type="text/javascript"
	src='<c:url value="/assets/js/jquery-3.2.1.min.js"/>'></script>
<script type="text/javascript">
	$(function() {

		setInterval("myTime()", 100);
		
		//Jquery Object 의 경우 변수 모호성을 명확하게 하기 위해 변수명 앞에 "$ + 변수명" 으로 처리 한다. 
		var $resultObj = $("#resultDiv");
		$("#naverLank").on("click", function() {
			$resultObj.ajaxReturnHTML("/naverLank.do");
		});

		$("#jsonViewTest").on("click", function() {
			$resultObj.ajaxReturnJSON("/jsonViewTest.do");
		});

		$("#mapToJsonTest").on("click", function() {
			$resultObj.ajaxReturnJSON("/mapToJsonTest.do");
		});
	});
	// $.extend()는 object들을 marge 하는것
	$.extend({
		resultDivEmtpy : function() {
			$("#resultDiv").empty();
		}
	});

	// $.fn.extend()의 경우 jquery prototype의 property를 확장한다는 뜻
	$.fn.extend({
		ajaxReturnHTML : function(url) {
			var $this = $(this);
			$.ajax({
				url : url,
				type : "get",
				dataType : "html"
			}).done(function(data) {
				$this.empty();
				$this.html(data);
			}).fail(
					function(request, status, error) {
						alert("code:" + request.status + "\n" + "message:"
								+ request.responseText + "\n" + "error:"
								+ error);
					});
		},
		ajaxReturnJSON : function(url) {
			var $this = $(this);
			$.ajax({
				url : url,
				type : "get",
				dataType : "json"
			}).done(function(data) {
				$this.empty();
				$this.html(JSON.stringify(data));
			}).fail(
					function(request, status, error) {
						alert("code:" + request.status + "\n" + "message:"
								+ request.responseText + "\n" + "error:"
								+ error);
					});
		}
	});

	function myTime() {
		var $now = new Date();
		var $hour = $now.getHours();
		var $minutes = $now.getMinutes();
		var $month = ($now.getMonth() + 1);
		var $day = $now.getDate();
		var time = "";

		var $type = "AM";
		if ($hour > 12) {
			$hour -= 12;
			$type = "PM";
		}
		time = fillZeros($month, 2) + "." + fillZeros($day, 2) + " "
				+ fillZeros($hour, 2) + ":" + fillZeros($minutes, 2) + ""
				+ $type;

		$("#time").html(time);
	}

	function fillZeros(n, digits) {
		var zero = '';
		n = n.toString();

		if (n.length < digits) {
			for (i = 0; i < digits - n.length; i++)
				zero += '0';
		}
		return zero + n;
	}
</script>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is <span id="time"></span>.</P>
	부산 날씨 ${weather } ${temper }℃<br>
	<span>PageMove</span>
	<br>
	<ul>
		<li>미세먼지</li>
	</ul>
	<br>
	<span>AJAX</span>
	<ul>
		<li><a href="javascript:;" id="naverLank">네이버랭킹</a></li>
		<li><a href="javascript:;" id="jsonViewTest">JsonViewTest</a></li>
		<li><a href="javascript:;" id="mapToJsonTest">JsonResultMap</a></li>
		<li><a href="/board/list" id="boardlist">게시판</a></li>
		<li><a href="/member/join" id="boardlist">회원가입</a></li>
		<li><a href="javascript:$.resultDivEmtpy();">결과초기화</a></li>
	</ul>
	<div id="resultDiv"></div>
</body>
</html>
