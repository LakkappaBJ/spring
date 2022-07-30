<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Data Update</title>
</head>
<body>
<form action="updateStudentDetails.student">
<pre>
 <label> Firstname: </label> <input type="text" name="firstname" value="${FISRName}"/> <br>
<label> Middlename: </label> <input type="text" name="middlename" value="${Middlename}" /><br>
<label> Lastname: </label> <input type="text" name="lastname" value="${Lastname}"/><br>
<label> Course : </label> <br> 
				<select name="course" value="${Course}">
					<option value="Course">Course</option>
					<option value="BCA">BCA</option>
					<option value="BBA">BBA</option>
					<option value="B.Tech">B.Tech</option>
					<option value="MBA">MBA</option>
					<option value="MCA">MCA</option>
					<option value="M.Tech">M.Tech</option>
				</select> <br>
<label> Gender : </label><br> 
<input type="radio" value="Male" name="gender" value="${Gender}" checked> Male 
<input type="radio" value="Female" name="gender" value="${Gender}">Female 
<input type="radio" value="Other" name="gender" value="${Gender}"> Other <br>
<input type="text" name="countrycode"
				placeholder="Country Code" value="${Countrycode}" size="2" />
<label> phone : </label><input type="text" name="phone" value="${Phone}" size="10" required > <br>
<label> Address : </label><textarea cols="80" rows="5"  name="address" value="${Address}" required>  </textarea><br>
<label for="email"><b>Email</b></label> <input type="text" name="email" value="${Email}" required><br>
<label	for="psw"><b>Password</b></label> 
				<input type="password" name="password" value="${Password}" required> <br>
<label for="psw-repeat"><b>Re-type Password</b></label> 
			<input type="password"  name="pswRepeat" value="${PswRepeat}" required><br>
<button type="submit" class="registerbtn">Register</button>
	</pre>		
</form>
</body>
</html>