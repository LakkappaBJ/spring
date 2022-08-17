<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Student Home Page</title>
<style>
 /* .container {
	padding:30%;
}  */ 

.button{
    padding: 13px;
    color: #191919;
    height: initial;
    width: 157px;
    margin-inline: 66px;
    background-color: pink;
    /* border: 155px; */
    border-radius: 19px;
}

.butt {
	box-shadow:inset 0px 1px 0px 0px #fce2c1;
	background:linear-gradient(to bottom, #ffc477 5%, #fb9e25 100%);
	background-color:#ffc477;
	border-radius:11px;
	border:2px solid #eeb44f;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:16px;
	font-weight:bold;
	padding:8px 18px;
	text-decoration:none;
	text-shadow:0px 1px 0px #cc9f52; 

}
.butt:hover {
	background:linear-gradient(to bottom, #fb9e25 5%, #ffc477 100%);
	background-color:#fb9e25;
}
.butt:active {
	position:relative;
	top:1px;
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

 .wrapper {
	position: relative;
	top: 50%;
	left: 50%;
	transform: translate(-62%, -64%);
	background: rgba(0, 0, 0, 0.6);
	max-width: 400px;
	width: 100%;
	padding: 5px;
	display: flex;
	justify-content: space-between;
	border-radius: 5px; 
} 
.wrapper .input {
	width: 85%;
	padding: 5px 10px;
	border: none;
	border-radius: 5px;
	font-weight: bold;
} 
.button3 {
  background-color: white; 
  color: black; 
  border: 2px solid #f44336;
  width: 83px;
    padding: 5px;
    font-size: 16px;
    font-weight: bold;
}
</style>
</head>

<body>
<a href="getAllStudentInfo.student"><button class="button">GetAllStudents</button></a> <br>
<button onclick="history.back()" class="button button3">Go Back</button>

<form action="searchStudentDetailsByName.student" method="post">
	<h3 style="color: red">${ErrMsg}</h3>
	<div class="wrapper">
	<input type="text" class="input" 
	placeholder=" Search Student name" name="studentName">
	<div><input type="submit" value="search" class="butt"></div>
</div> 
</form>

<form action="searchForUpdating.student" method="get">
	<h3 style="color: red">${ErrMsg}</h3>
	<div class="wrapper">
	<input type="text" class="input" 
	placeholder=" updates Student name" name="studentName">
	<div><input type="submit" value="Update" class="butt"></div>
</div> 

</form>
	<h1 style="color: green;">${DeleteSuccess}</h1>
	<h3 style="color: red;">${DeleteMSG}</h3>
	<h3 style="color: red;">${ErrorMsg}</h3>
	<h3 style="color: red;">${ErrrMsg}</h3>
	
	<form action="deleteByName.student" method="post">
	<div class="wrapper">
	<input type="text" class="input" 
	placeholder=" Delete Student name" name="studentName">
	<div><input type="submit" value="DELETE"  class="butt"></div>
</div>
</form>

	<form action="saveStudentDetails.student" method="post">
	<div class="container">
			<center>
			<h2 style="color: green;">${success}</h2>
				<h1>Student Registeration Form</h1>
			</center>
			<hr>
			<p style="color: red;">${FNAME}</p>
			<label> Firstname: </label> <input type="text" name="firstname" 
				placeholder="Firstname"  />
				
				<p style="color: red;">${MNAME}</p>
			<label> Middlename: </label> <input type="text" name="middlename" 
				placeholder="Middlename" />
				<p style="color: red;">${LNAME}</p>
			<label> Lastname: </label> <input type="text" name="lastname" 
				placeholder="Lastname" />
			<div>
				<p style="color: red;">${COURSE}</p>
				<label> Course : </label> <select name="course" > 
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
				<label> Gender : </label><br> 
				<input type="radio" value="Male" name="gender"  checked> 
					Male <input type="radio" value="Female" name="gender">
					 Female <input type="radio" value="Other" name="gender"> Other

			</div>
			<p style="color: red;">${PHONE}</p>
			<label> Phone : </label> 
			<input type="text" name="countrycode"
				placeholder="Country Code" value="+91" size="2" /> 
				
	<input
				type="text" name="phone"  placeholder="phone no." size="10"
				 required> Current Address :
				
				<p style="">${ADDRESS}</p>
			<textarea cols="80" rows="5" placeholder="Current Address"  name="address"  required>  
</textarea>
			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" name="email"   required>
				
				 <label
				for="psw"><b>Password</b></label> 
				<input type="password"
				placeholder="Enter Password" name="password"  required> <label
				for="psw-repeat"><b>Re-type Password</b></label> <input
				type="password" placeholder="Retype Password" name="pswRepeat" 
				required>
			<button type="submit" class="registerbtn">Save/Update</button>
		</div>
	</form>
	<h1>student details by name</h1> <br>
<table border="3" cellpadding = "5" cellspacing = "5" >
		<tr><!-- Table heading -->
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
		<!-- only search -->
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
		
		<!-- all details -->
		<c:forEach items="${getAllStudentDetails}" var="x"> 
		<tr>
			<td>${x.firstname}</td>
			<td>${x.middlename}</td>
			<td>${x.lastname}</td>
			<td>${x.course}</td>
			<td>${x.gender}</td>
			<td>${x.countrycode}</td>
			<td>${x.phone}</td>
			<td>${x.address}</td>
			<td>${x.email}</td>
			<td>${x.password}</td>
			<td>${x.pswRepeat}</td>
		</tr>
		</c:forEach>
	</table> <br> <br>
	<!-- <a href="updateStudentDetails.student">UPDATE</a> -->
</body>
</html>