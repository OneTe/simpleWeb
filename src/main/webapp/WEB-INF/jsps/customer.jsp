<%--
  Created by IntelliJ IDEA.
  User: wangcheng
  Date: 2018/6/7
  Time: 下午4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>客户列表</h1>
<table>
    <tr>
        <th>客户名称</th>
        <th>联系人</th>
        <th>电话号码</th>
        <th>邮箱地址</th>
        <th>操作</th>
    </tr>
    <c:forEach var="customerList" items="${customerList}">
        <tr>
            <td>${customerList.name}</td>
            <td>${customerList.contact}</td>
            <td>${customerList.telephone}</td>
            <td>${customerList.email}</td>
            <td>
                <a href="${BASE}/customer_edit?id=${customerList.id}">编辑</a>
                <a href="${BASE}/customer_delete?id=${customerList.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
