<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/13
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h2>执行成功</h2>

    <%--EL表达式：从request域中把user对象的username、password值取出来--%>
    ${user.username}
    ${user.password}

</body>
</html>
