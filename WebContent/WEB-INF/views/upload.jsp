
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
<!--
#uploaddiv {
	position: absolute;
	top: 300px;
	left: 970px;
	background-image: url(/Assignment10/images/click.png);
	width: 250px;
	height: 250px;
	border: 5px dashed;
	background-size: 255px 255px;
}

#uploaddiv input, label {
	display: none;
}

div#headingupload {
	position: relative;
	text-align: centre;
	left: 35%;
}
-->
</style>
<div id="uploaddiv">
	<form id="uploadForm" method="post" action="uploadFile"
		enctype="multipart/form-data">

		<input type="file" id="fileupload" name="fileUpload" /> <input
			id="filesubmit" type="submit" value="upload" />
	</form>
</div>
<div id="headingupload">
	<h1>UPLOAD NEW FLIGHT DATA</h1>
	${resultMsg}
	<form:errors path="fileUpload" />
</div>
<script type="text/javascript" src="/Assignment10/scripts/jquery.js"></script>

<script>
	var x = 0;
	function divOnClick(event) {
		console.log("div clicked----" + x);
		if (x != 1) {
			x = 1;
			console.log("input clicked----" + x)
			event.stopprapagation;
			$('#fileupload').click();
		}
	}
	$('#uploaddiv').on('click', divOnClick);
	$('#fileupload').on(
			'change',
			function(e) {
				var mimeType = e.target.files[0].type;
				if (mimeType.match("text/csv")
						|| mimeType.match('application/vnd.ms-excel')) {
					$('#filesubmit').click();
					alert(e.target.files[0].name + " Uploaded");
				} else {
					alert("only Csv files Allowed");
				}
				x = 0;
			});
	$('#uploaddiv').on('dragover', function(e) {
		e.preventDefault();
		e.stopPropagation();
	});

	$('#uploaddiv').on('dragleave', function(e) {
		e.preventDefault();
		e.stopPropagation();
	});

	$('#uploaddiv').on(
			'drop',
			function(e) {
				e.preventDefault();
				e.stopPropagation();
				e.dataTransfer = e.originalEvent.dataTransfer;
				files = e.dataTransfer.files;
				var progressBar = $("#progressBar");
				var percentageDiv = $("#progressDiv");

				for (var i = 0; i < files.length; i++) {
					var mimeType = files[0].type;
					if (mimeType.match("text/csv")
							|| mimeType.match('application/vnd.ms-excel')) {
						var form = new FormData();
						form.append("fileUpload", files[i]);

						var xhr = new XMLHttpRequest();
						xhr.open("POST", "uploadFile", true);
						xhr.setRequestHeader("X_FILENAME", files.name);
						xhr.send(form);
						xhr.upload.addEventListener("progress", function(evt) {
							console.log(evt.loaded);
							console.log("yes")
							if (evt.lengthComputable) {
								progressBar.max = evt.total;
								progressBar.value = evt.loaded;
								percentageDiv.innerHTML = Math.round(evt.loaded
										/ evt.total * 100)
										+ "%";
							}
						}, false);
					} else {
						alert(files[i].name + " is not a csv file");
					}
				}
			});
</script>