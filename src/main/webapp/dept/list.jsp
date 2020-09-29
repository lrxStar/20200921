<%@ page import="java.util.List" %>
<%@ page import="com.etc.domain.Dept" %><%--
  Created by IntelliJ IDEA.
  User: 梁瑞新
  Date: 2020/9/21
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Dept> deptList = (List<Dept>) request.getAttribute("deptList");

    for (Dept dept : deptList) {
        out.print(dept);
    }
%>
</body>
</html>
