<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<style type="text/css">
	select { width: 200px; }
</style>
</head>
<body>
1단계 : <select id="first" name="doValue" onchange="changeSi()">
			<option>===선택하세요===</option>
			<c:forEach var="doValue" items="${doList}">
			<option value="${doValue.code}">${doValue.name}</option>
			</c:forEach>
		</select>
2단계 : <select id="second" onchange="changeDong()"><option>===선택하세요===</option></select>
3단계 : <select id="third"><option>===선택하세요===</option></select>
<script>
	function changeSi() {
		var opValue = $("#first").val();
		$.ajax({
			dataType: "json",
			url: "/javascript-basic/selectSi",
			data: { "doValue" : opValue },
			success: function (result) {
				$("#second").html("<option>===선택하세요===</option>");
				$("#third").html("<option>===선택하세요===</option>");
				for (var i = 0; i < result.length; i++) {
					var si = result[i];
					$("#second").html($("#second").html() + "<option value='" + si.code + "'>" + si.name + "</option>");
				}
			}
		});
	}
	
	function changeDong() {
		var opValue = $("#second").val();
		$.ajax({
			dataType: "json",
			url: "/javascript-basic/selectDong",
			data: { "doValue" : opValue },
			success: function (result) {
				$("#third").html("<option>===선택하세요===</option>");
				for (var i = 0; i < result.length; i++) {
					var dong = result[i];
					$("#third").html($("#third").html() + "<option value='" + dong.code + "'>" + dong.name + "</option>");
				}
			}
		});
	}
</script>
</body>
</html>