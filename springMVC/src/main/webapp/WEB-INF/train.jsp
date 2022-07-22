<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IRCTC</title>
	
</head>
<style>


@import url("https://fonts.googleapis.com/css2?family=Sansita+Swashed:wght@600&display=swap");
body {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: linear-gradient(45deg, greenyellow, dodgerblue);
  font-family: "Sansita Swashed", cursive;
}
.center {
  position: relative;
  padding: 50px 50px;
  background: #fff;
  border-radius: 10px;
}
.center h1 {
  font-size: 2em;
  border-left: 5px solid dodgerblue;
  padding: 10px;
  color: #000;
  letter-spacing: 5px;
  margin-bottom: 60px;
  font-weight: bold;
  padding-left: 10px;
}
.center .inputbox {
  position: relative;
  width: 300px;
  height: 50px;
  margin-bottom: 50px;
}
.center .inputbox input {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  border: 2px solid #000;
  outline: none;
  background: none;
  padding: 10px;
  border-radius: 10px;
  font-size: 1.2em;
}
.center .inputbox:last-child {
  margin-bottom: 0;
}
.center .inputbox span {
  position: absolute;
  top: 14px;
  left: 20px;
  font-size: 1em;
  transition: 0.6s;
  font-family: sans-serif;
}
.center .inputbox input:focus ~ span,
.center .inputbox input:valid ~ span {
  transform: translateX(-13px) translateY(-35px);
  font-size: 1em;
}
.center .inputbox [type="submit"] {
  width: 50%;
  background: dodgerblue;
  color: #fff;
  border: #fff;
}
.center .inputbox:hover [type="submit"] {
  background: linear-gradient(45deg, greenyellow, dodgerblue);
}



</style>
<body>
	<!-- <form action="readValuesFromPage">
		<pre>
		Train.No: <input type="text" name="trainNo">  <br>
		Train Name: <input type="text" name="trainName"> <br>
		<input type="submit" value="click">
		</pre>
	</form> -->
<form action="readValuesFromPage">

<div class="center">
  <h1>Add Trains</h1>
  <form>
  <p style="color: red;">${errorMsg}</p>
    <div class="inputbox">
      <input type="text" name="trainNo">
      <span>Train.No:</span>
    </div>
    <div class="inputbox">
      <input type="text" name="trainName">
      <span>Train Name:</span>
    </div>
    <div class="inputbox">
      <input type="submit" value="click">
    </div>
    <button onclick="location.href='http://localhost:8080/mvccontrollertodto/getAllTrains'" type="button" style="color: red";>View</button>
  </form>
</div>
</form>



</body>
</html>