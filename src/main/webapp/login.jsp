<%--
  Created by IntelliJ IDEA.
  User: kst
  Date: 2020/8/4
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/queryUserPwd.do" method="post">
        用户名：<input type="text" name="userName"><br>
        密  码：<input type="password" name="userPassWord"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
