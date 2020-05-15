<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/14
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

    <h2>传统文件上传方式</h2>

    <form action="user/fileUpload1" method="post" enctype="multipart/form-data">
        选择上传文件：<input type="file" name="upload" /><br/>
        <input type="submit" value="上传" />
    </form>

    <h2>SpringMVC文件上传方式</h2>
    <form action="user/fileUpload2" method="post" enctype="multipart/form-data">
        选择上传文件：<input type="file" name="upload" /><br/>
        <input type="submit" value="上传" />
    </form>

    <h2>跨服务器文件上传</h2>
    <form action="user/fileUpload3" method="post" enctype="multipart/form-data">
        选择上传文件：<input type="file" name="upload" /><br/>
        <input type="submit" value="上传" />
    </form>

</body>
</html>
