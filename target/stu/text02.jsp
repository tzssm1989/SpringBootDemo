<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<meta charset="UTF-8">
		<title>阿里人脸识别测试页</title>
		<link rel="stylesheet" href="css/mybootstrap.css">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	</head>
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script>
		function test() {
			//			var form = new FormData(document.getElementById("form"));
			var formData = new FormData();
			formData.append('image1', $('#InputFile1')[0].files[0]);
			formData.append('image2', $('#InputFile2')[0].files[0]);

			$.ajax({
				url: "/facecompare",
				type: "post",
				data: formData,
				cache: false,
				processData: false,
				contentType: false,
				success: function(data) {
					alert(data);
					var jsonobj = eval("("+data+")");
					$("#le3").val(jsonobj.thresholds[0]);
					$("#le4").val(jsonobj.thresholds[1]);
					$("#le5").val(jsonobj.thresholds[2]);
					$("#confidence").val(jsonobj.confidence);
				},
				error: function(e) {
					alert(e);
				}
			});
		}

		function getFileUrl(sourceId) {
			var url;
			if(navigator.userAgent.indexOf("MSIE") >= 1) { // IE 		
				url = document.getElementById(sourceId).value;
			} else if(navigator.userAgent.indexOf("Firefox") > 0) { // Firefox 		
				url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
			} else if(navigator.userAgent.indexOf("Chrome") > 0) { // Chrome 		
				url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
			}
			return url;
		}

		var url1;

		function preImg(sourceId, targetId) {
			var url = getFileUrl(sourceId);
			url1 = url;
			var imgPre = document.getElementById(targetId);
			imgPre.src = url;
		}
	</script>

	<body>
		<div class="container-fluidtop">
			<div class="row">
				<div class="col-md-3">
					<form enctype="multipart/form-data" id="form1">
						<label for="exampleInputFile">A用户图片数据：</label>
						<input type="file" id="InputFile1" onchange="preImg(this.id,'imgPre');">
						<!--<input type="file" id="InputFile1">-->
						<img id="imgPre" src="" width="50px" height="50px" style="display: block;" />
						<!--<input type="button" class="btn btn-success" id="buttion1" onclick="test()" value="提交">
						<input type="button" class="btn btn-danger" id="buttion3" onclick="clearimage()" value="清空" />-->

				</div>
				<div class="col-md-3">
					<form enctype="multipart/form-data" id="form2"></form>
					<label for="exampleInputFile">B用户图片数据：</label>
					<input type="file" id="InputFile2" onchange="preImg(this.id,'imgPre2');">
					<img id="imgPre2" src="" width="50px" height="50px" style="display: block;" />
					<input type="button" class="btn btn-success" id="buttion2" onclick="test()" value="比对">
				</div>
				</form>
				<div class="col-md-6">

					<label for="exampleInputFile">比对结果是：</label> request_id :<input type="text" id="request_id" /><br /> time_used:
					<input type="text" id="time_used" /><br /> thresholds:
					<br /> le-3:
					<input type="text" id="le3" /><br /> le-4:
					<input type="text" id="le4" /><br /> le-5:
					<input type="text" id="le5" /><br /> results:
					<br /> confidence（置信度）:
					<input type="text" id="confidence" /><br /> userid:
					<input type="text" id="user_id" /><br /> face_token:
					<input type="text" id="face_token" /><br /> 如果confidence > 1e-5 则同一个人的可能信非常大<br /> 如果confidence
					< 1e-3 则不认定为同一个人 </div>
				</div>

			</div>

			<div class="container-fluidfoot" id="foot">

			</div>
	</body>

</html>