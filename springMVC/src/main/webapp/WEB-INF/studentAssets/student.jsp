<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Calibri, Helvetica, sans-serif;
	background-color: pink; 
	
}

.container {
	padding:30%;

	   background-color: lightblue; 
}

input[type=text], input[type=password], textarea {
	width: 100%;
	padding: 10px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: red;
	outline: none;
}

div {
	padding: 5px 0;
}

hr {
	border: 2px solid #f1f1f1;
	margin-bottom: 25px;
}

.registerbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}




.wrapper{
	 position: relative;
    top:50%;
    left: 50%; 
    transform: translate(-50%,22%);
    background: rgba(0, 0, 0,0.6);
    max-width: 600px;
    width: 100%;
   padding: 5px;
    display: flex;
    justify-content: space-between;
    border-radius: 5px;
}

.wrapper .input {
    width: 85%;
    padding: 15px 20px;
    border: none;
    border-radius: 5px;
    font-weight: bold;
}

.searchbtn {
    background: #ffec00;
    width: 10%;
    border-radius: 5px;
    position: relative;
    cursor: pointer;
}

.searchbtn .fas{
	position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    font-size: 18px;
}
td {
  text-align: center;
}
table.center {
  margin-left: auto; 
  margin-right: auto;
}
</style>
</head>
<body>
	<form action="studentDetails">
		<div class="container">
			<center>
				<h1>Student Registeration Form</h1>
			</center>
			<hr>
			<p style="color: red">${FNAME}</p>
			<label> Firstname </label> <input type="text" name="firstname"
				placeholder="Firstname" />
			<p style="color: red">${MNAME}</p>
			<label> Middlename: </label> <input type="text" name="middlename"
				placeholder="Middlename" />
			<p style="color: red">${LNAME}</p>
			<label> Lastname: </label> <input type="text" name="lastname"
				placeholder="Lastname" />
			<div>
				<label> Course : </label> <select name="course">
					<option value="Course">Course</option>
					<option value="BCA">BCA</option>
					<option value="BBA">BBA</option>
					<option value="B.Tech">B.Tech</option>
					<option value="MBA">MBA</option>
					<option value="MCA">MCA</option>
					<option value="M.Tech">M.Tech</option>
				</select>
			</div>
			<div>
				<label> Gender : </label><br> <input type="radio" value="Male"
					name="gender" checked> Male <input type="radio"
					value="Female" name="gender"> Female <input type="radio"
					value="Other" name="gender"> Other

			</div>
			<label> Phone : </label> <input type="text" name="countrycode"
				placeholder="Country Code" value="+91" size="2" /> <input
				type="text" name="phone" placeholder="phone no." size="10"
				/ required> Current Address :
			<textarea cols="80" rows="5" placeholder="Current Address"
				value="address" name="address" required>  
</textarea>
			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" name="email" required> <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required> <label
				for="psw-repeat"><b>Re-type Password</b></label> <input
				type="password" placeholder="Retype Password" name="pswRepeat"
				required>
			<button type="submit" class="registerbtn">Register</button>
	</form>
	
	
	<form action="searchByName">
	<p ><h3 style="color: red">${ErrMsg}</h3></p>
	<div class="wrapper">
	<input type="text" class="input" 
	placeholder=" Search Student name" name="studentName">
	<div class="searchbtn"><input type="submit" value="search"></div>
</div> <br> <br>

</form>
<%-- 
		<ol>
			<li>${FISRName}</li>
			<li>${Middlename}</li>
			<li>${Lastname}</li>
			<li>${Course}</li>
			<li>${Gender}</li>
			<li>${Countrycode}</li>
			<li>${Phone}</li>
			<li>${Address}</li>
			<li>${Email}</li>
			<li>${Password}</li>
			<li>${PswRepeat}</li>

		</ol> --%>

		<table border="3" cellpadding = "5" cellspacing = "5" class="center">
		<tr>
			<th>FIRSTNAME</th>
			<th>MIDDLENAME</th>
			<th>LASTNAME</th>
			<th>COURSE</th>
			<th>GENDER</th>
			<th>COUNTRYCODE</th>
			<th>PHONE</th>
			<th>ADDRESS</th>
			<th>EMAIL</th>
			<th>PASSWORD</th>
			<th>PSWREPEAT</th>

		</tr>
		<tr>
			<td>${FISRName}</td>
			<td>${Middlename}</td>
			<td>${Lastname}</td>
			<td>${Course}</td>
			<td>${Gender}</td>
			<td>${Countrycode}</td>
			<td>${Phone}</td>
			<td>${Address}</td>
			<td>${Email}</td>
			<td>${Password}</td>
			<td>${PswRepeat}</td>
		</tr>
	</table>
	
</body>
</html>
