<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/13
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="../../../../../SpringMVC_02_response/src/main/webapp/js/jquery.min.js"></script>

    <script>
        // 页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                // alert("hello btn");
                // 发送ajax请求
               $.ajax({
                  // 编写json格式，设置属性和值
                   url:"user/testAjax",
                   contentType:"application/json;charset=utf-8",
                   data:'{"username":"hehe","password":"123","age":"30"}',
                   dataType:"json",
                   type:"post",
                   success:function (data) {
                        // data：服务器端响应给json的数据，并解析
                       alert(data);
                       alert(data.username);
                       alert(data.password);
                       alert(data.age);
                   }
               });
            });
        });
    </script>

</head>
<body>

    <%--响应与结果视图：返回值是String--%>
    <a href="user/testString">testString</a>

    <br/>

    <%--响应与结果视图：返回值是Void--%>
    <a href="user/testVoid">testVoid</a>

    <br/>

    <%--响应与结果视图：返回值是ModelAndView对象--%>
    <a href="user/testModelAndView">testModelAndView</a>

    <br/>

    <button id="btn">发送ajax请求</button>

</body>
</html>
