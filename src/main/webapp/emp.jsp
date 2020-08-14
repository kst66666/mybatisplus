<%--
  Created by IntelliJ IDEA.
  User: kst
  Date: 2020/7/3
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="jquery-3.4.1.js"></script>
<script type="text/javascript">

</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="button" value="添加" onclick="saveStu()"><br>
    <table border="1">
        <tr>
            <td>姓名</td>
            <td>职位</td>
            <td>入职日期</td>
            <td>工资</td>
            <td>手机号</td>
            <td>部门</td>
            <td>图片</td>
        <c:forEach items="${emp}" var="e">
            </tr>
                <td>${e.ename}</td>
                <td>${e.postno}</td>
                <td>${e.hiredate}</td>
                <td>${e.sal}</td>
                <td>${e.phone}</td>
                <td>${e.deptno}</td>
                <td><img style="width:80px;height: 50px;" src="${e.img}" alt="图片子"></td>
                <td>
                    <form action="/queryEmpById.do" method="post">
                        <input type="hidden" name="empno" value="${e.empno}">
                        <input type="submit" value="修改">
                    </form>
                    <form action="/deleteEmp.do" method="post">，
                          <input type="hidden" name="empno" value="${e.empno}">
                        <input type="submit" value="删除">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
