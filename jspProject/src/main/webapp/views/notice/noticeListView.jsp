<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.notice.model.vo.Notice"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        background: black;
        color: white;
        width: 1000px;
        height: 500px;
        margin:auto;
        margin-top: 50px;
    }
    .list-area{
        border: 1px solid white;
        text-align: center;
    }
	.list-area > tbody > tr:hover{
		background: gray;
		cursor: pointer;
	}
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>

    <div class="outer">
        <br>
        <h2 align="center">공지사항</h2>
        <br>
		
		<% if ( loginUser != null && loginUser.getUserId().equals("admin")) { %>
        <!-- 현재 로그인한 사용자가 관리자일 경우에 보여짐 -->
        <div align="right" style="width: 850px;">
            <a href="<%=contextPath %>/enroll.no" class="btn btn-sm btn-secondary">글쓰기</a>
        </div>
		<% } %>
        <table class="list-area" align="center">
            <thead>
                <th>글번호</th>
                <th width="400">글제목</th>
                <th width="100">작성자</th>
                <th>조회수</th>
                <th width="100">작성일</th>
            </thead>
            <tbody>
            <% if (list.isEmpty()) { %>
            <!-- case1. 공지사항이 없을경우 -->
            <tr>
                <td colspan="5">존재하는 공지사항이 없습니다.</td>
            </tr>
            <%} else { %>
            <!-- case2. 공지사항이 있을경우 -->
            <% for (Notice n : list) {%>
                <tr>
                    <td><%= n.getNoticeNo() %></td>
                    <td><%= n.getNoticeTitle() %></td>
                    <td><%= n.getNoticeWriter() %></td>
                    <td><%= n.getCount() %></td>
                    <td><%= n.getCreateDate() %></td>
                </tr>
                <% } %>
            <% } %>
            </tbody>
        </table>
    </div>
    <script>
    	const trList = document.querySelectorAll(".list-area>tbody>tr");
        for (const tr of trList) {
            tr.onclick = function() {
                const noticeNo = this.childNodes[1].innerText
                
                // 요청한 url?키=벨류&키=벨류;
                // 쿼리스트림
                location.href = "<%=contextPath%>/detail.no?num=" + noticeNo;
            }
        }

        // $(function(){
        //     $(".list-area>tbody>tr").click(function(){
        //         console.log($(this).children().eq(0).text())
        //     })
        // })
    </script>
</body>
</html>