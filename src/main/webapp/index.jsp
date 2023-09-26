<%@ page import="top.hyzhu.utils.DataUtil" %>
<%@ page import="top.hyzhu.entity.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zhuhuiyu
  Date: 2023/9/13
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功页面</title>
    <style>
        .student-box {
            text-align: center;
            display: inline-block;
            width: 300px;
            /*height: 200px;*/
            background-color: #0dcaf0;
        }

        .student-box .avatar {
            width: 80px;
            height: 80px;
            border-radius: 100%;
        }
    </style>
</head>
<body>
<h2>
    <%=request.getParameter("account")%>登录成功
</h2>
<%
    List<Student> students = DataUtil.getStudents();
    for (Student student : students) {
%>
<div class="student-box">
    <h3>
        <%=student.getName()%>
    </h3>
    <img src="<%=student.getAvatar()%>" alt="头像" class="avatar">
    <p>
        <%=student.getSign()%>
    </p>
    <p>
        <%=student.getBirthday()%>
    </p>
</div>


<%}%>

</body>
</html>
