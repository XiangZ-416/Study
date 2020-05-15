<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/13
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常用注解的演示</title>
</head>
<body>

    <h3>常用注解的演示</h3>

    <%--@RequestParam--%>
    <a href="anno/testRequestParam?name=hehe">testRequestParam</a>

    <%--@RequestBody--%>
    <form action="anno/testRequestBody" method="post">
        用户姓名：<input type="text" name="username"/><br/>
        用户年龄：<input type="text" name="age"/><br/>
        <input type="submit" value="提交"/>
    </form>

    <%--@PathVariable--%>
    <a href="anno/testPathVariable/10">testPathVariable</a>

    <%--@PathVariable--%>
    <a href="anno/testRequestHeader">testRequestHeader</a>

    <%--@CookieValue注--%>
    <a href="anno/testCookieValue">testCookieValue</a>

    <%--@ModelAttribute--%>
    <form action="anno/testModelAttribute" method="post">
        用户姓名：<input type="text" name="uname"/><br/>
        用户年龄：<input type="text" name="age"/><br/>
        <input type="submit" value="提交"/>
    </form>

    <%--@SessionAttributes：存值--%>
    <a href="anno/testSessionAttributes">testSessionAttributes</a>
    <%--@SessionAttributes：取值--%>
    <a href="anno/getSessionAttributes">getSessionAttributes</a>
    <%--@SessionAttributes：删值--%>
    <a href="anno/deleteSessionAttributes">deleteSessionAttributes</a>


</body>
</html>
