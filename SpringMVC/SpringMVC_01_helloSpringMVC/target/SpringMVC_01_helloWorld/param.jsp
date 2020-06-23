<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/12
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>

<%--请求参数绑定--%>
<%--    <h2>请求参数绑定：基本数据类型和字符串类型</h2>--%>
<%--    <a href="param/testParam?username=hehe&password=123">请求参数绑定</a>--%>

<%--    <h2>请求参数绑定：实体类型（JavaBean）</h2>--%>
<%--    <form action="param/saveAccount" method="post">--%>
<%--        姓名：<input name="username" type="text"/><br/>--%>
<%--        密码：<input type="text" name="password" /><br/>--%>
<%--        金额：<input type="text" name="money" /><br/>--%>
<%--        用户姓名：<input type="text" name="user.uname" /><br/>--%>
<%--        用户年龄：<input type="text" name="user.age" /><br/>--%>
<%--        <input type="submit" value="提交" />--%>
<%--    </form>--%>

<%--    <h2>请求参数绑定：类中存在集合数据类型（List、map集合等）</h2>--%>
<%--    <form action="param/saveAccount" method="post">--%>
<%--        姓名：<input name="username" type="text"/><br/>--%>
<%--        密码：<input type="text" name="password"/><br/>--%>
<%--        金额：<input type="text" name="money"/><br/>--%>

<%--        用户姓名：<input type="text" name="list[0].uname"/><br/>--%>
<%--        用户年龄：<input type="text" name="list[0].age"/><br/>--%>

<%--        用户姓名：<input type="text" name="map['one'].uname"/><br/>--%>
<%--        用户年龄：<input type="text" name="map['one'].age"/><br/>--%>
<%--        <input type="submit" value="提交"/>--%>
<%--    </form>--%>

<%--    <h2>请求参数绑定：自定义类型转换器</h2>--%>
<%--    <form action="param/saveUser" method="post">--%>
<%--        用户姓名：<input type="text" name="uname"/><br/>--%>
<%--        用户年龄：<input type="text" name="age"/><br/>--%>
<%--        用户生日：<input type="text" name="date"/><br/>--%>
<%--        <input type="submit" value="提交"/>--%>
<%--    </form>--%>

    <!--获取原生的ServletAPI对象-->
    <a href="param/testServlet">Servlet原生的API</a>

</body>
</html>
