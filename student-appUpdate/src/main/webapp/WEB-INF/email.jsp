<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmailProject</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel = "icon" href ="https://www.x-workz.in/assets/images/Logo.png" type = "image/x-icon" > 
</head>
<body>
	<h2 style="color: green;">${msg}</h2>
	<h2 style="color: red;">${Errmsg}</h2>
	<form class="row g-3" action="sendEmail.student" method="post">
		<div class="col-md-6">
		<p style="color: red;">${Email}</p>
			<label for="">Recipients: </label><input type="text" name="emailId" placeholder="Enter email id" > <br> 
			
			<p style="color: red;">${Subject}</p>
				<label for="">Subject: </label> <input type="text" name="subject" placeholder="subject" > <br>
				
				<p style="color: red;">${Desc}</p>
			<input type="text" name="description" placeholder="description" ><br>
			<button type="submit" class="btn btn-primary">send</button>
		</div>
	</form>
</body>
</html>

