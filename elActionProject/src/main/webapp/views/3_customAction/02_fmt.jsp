<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1. formatNumber </h3>
	<p>
		숫자데이터의 포멧(형식) 지정<br>
		- 표현하고자하는 숫자데이터의 형식을 통화기호, % 등 원하는 쓰임에 맞네 형식을 지정하는 태그<br><br>
		
		(fmt:formatNumber value="출력할 값" [groupingUsed ="true|false" type="percent|currency" currencySymbol="문자"])
	</p>
	
	<c:set var="num1" value="123456789" />
	<c:set var="num2" value="0.75" />
	<c:set var="num3" value="50000" />
	
	그냥 출력 : ${num1 }<br>
	세저리마다 구분하여 출력 <fmt:formatNumber value="${num1}" /> <br> <!-- groupingUsed기본값(true) -->
	숫자 그대로 출력 <fmt:formatNumber value="${num1}" groupingUsed="false" /> <br>
	<!--  gorupingUsed : 세자리마다 구분자(,) 표시여부를 지정 -->
	
	
	percent : <fmt:formatNumber value="${num2}" type="percent" /> <br>
	current : <fmt:formatNumber value="${num3}" type="currency" groupingUsed="false" /> <br>
	current : <fmt:formatNumber value="${num3}" type="currency" groupingUsed="false" currencySymbol="$" /> <br>
	<!-- 
		type : 백분율(%), 통화기호 형식 지정
		currencySymbol : 통화기호 문자 지정
	 -->

	 <h3>2. formatDate</h3>
	 <p>날짜 및 시간 데이터의 포맷 지정(단, java.util.Date 객체 사용)</p>

	 <c:set var="current" value="<%= new java.util.Date() %>" />
	 
	 그냥 출력: ${current}
	 
	 <ul>
	 	<li>현재 날짜:<fmt:formatDate value="${current}" /></li> <!-- type생략시 기본값이 date -->
	 	<li>현재 시간:<fmt:formatDate value="${current}" type="time" /></li>
	 	<li>둘 다:<fmt:formatDate value="${current}" type="both" /></li> <!-- dateStyle, timeStyle 생략시 기본값 medium -->
	 	<li>Medium:<fmt:formatDate value="${current}" type="both" dateStyle="medium" timeStyle="medium" /></li>
	 	<li>Long:<fmt:formatDate value="${current}" type="both" dateStyle="Long" timeStyle="Long" /></li>
	 	<li>Full:<fmt:formatDate value="${current}" type="both" dateStyle="Full" timeStyle="Full" /></li>
	 	<li>Short:<fmt:formatDate value="${current}" type="both" dateStyle="Short" timeStyle="Short" /></li>
	 	<li>내 패턴:<fmt:formatDate value="${current}" type="both" pattern="yyyy-MM-dd(E) HH:mm:ss(a)"  /></li>
	 </ul>

</body>
</html>