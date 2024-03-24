<%@ page import="javax.swing.*" %>
<%@ page import="com.kitri.miniproject_todolist.dto.SignUpMember" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="/todo/style.css"/>
    <title>Todo List</title>

</head>
<body>

<%
    SignUpMember sessionInfo = (SignUpMember) session.getAttribute("memberSession");
    if (sessionInfo != null) {
%>
<h4><%=sessionInfo.getName()%>님 환영합니다.</h4>
<a href="/login/logout"> 로그아웃 </a>
<%}%>

<h1>todo-list</h1>
<form id="form">
    <input type="text" class="input" id="input" placeholder="Enter your todo" autocomplete="off">

    <ul class="todos" id="todos"></ul>
</form>
<small>왼쪽 클릭: 항목 완료 <br> 오른쪽 클릭: 해당 항목 삭제</small>

<script>
    let sessionId = <%=sessionInfo.getId()%>
</script>
<script src="/todo/todolist.js"></script>


</body>

</html>