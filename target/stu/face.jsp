<%--
  Created by IntelliJ IDEA.
  User: songsm
  Date: 2018/9/30
  Time: 上午9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人脸识别测试页</title>
    <link rel="stylesheet" href="css/mybootstrap.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"/>
    <script>
        $(document).ready(function () {
            $("#buttion1").click(function () {
                alert("ok");
            });
        });
    </script>

</head>
<body>

<%--<div class="">--%>
<%--<label for="exampleInputFile">图片：</label>--%>
<%--<input type="file" id="exampleInputFile">--%>
<%--</div>--%>

<%--<div >--%>
<%--<img src="404.html" />--%>
<%--</div>--%>

<div class="container-fluidtop">

    <div class="row">
        <div class="col-lg-3">
            <label for="exampleInputFile">添加用户图片数据：</label>
            <input type="file" id="InputFile1">
            <input type="button" id="buttion1" value="提交">
        </div>
        <div class="col-lg-3">
            <label for="exampleInputFile">比对图片：</label>
            <input type="file" id="InputFile2">
            <input type="button" id="buttion2" value="比对">
        </div>
        <div class="col-lg-6">
            <label for="exampleInputFile">比对结果是：</label>
        </div>
    </div>


</div>

<div class="container-fluidfoot">

    <div class="col-lg-2">
        <img src="images/404.jpg" width="200" height="200">
    </div>
    <div class="col-lg-2">
        <img src="images/404.jpg" width="200" height="200">
    </div>
    <div class="col-lg-2">
        <img src="images/404.jpg" width="200" height="200">
    </div>
    <div class="col-lg-2">
        <img src="images/404.jpg" width="200" height="200">
    </div>
    <div class="col-lg-2">
        <img src="images/404.jpg" width="200" height="200">
    </div>
    <div class="col-lg-2">
        <img src="images/404.jpg" width="200" height="200">
    </div>
    <div class="col-lg-2">
        <img src="images/404.jpg" width="200" height="200">
    </div>
    <div class="col-lg-2">
        <img src="images/404.jpg" width="200" height="200">
    </div>
    <div class="col-lg-2">
        <img src="images/404.jpg" width="200" height="200">
    </div>

</div>


</body>
</html>
