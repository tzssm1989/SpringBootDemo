<%--
  Created by IntelliJ IDEA.
  User: songsm
  Date: 2018/7/20
  Time: 上午8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>

       <form action="/savedocument" enctype="multipart/form-data" method="post">

           文档标题：<input type="text" id="documenttitle" name="documenttitle" placeholder="shangchuan" />

           文档内容：<textarea rows="10" name="documentdes" cols="10"></textarea>

           文档：<input type="File" id="file" name="file"/>


           <input type="submit" value="提交" />


       </form>

</body>
</html>
