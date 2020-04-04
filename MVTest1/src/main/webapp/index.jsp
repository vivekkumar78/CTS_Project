<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {box-sizing: border-box}
body {font-family: Arial, Helvetica, sans-serif;
	background-image:url('images/saand.jpg');
	background-repeat: no-repeat;
	background-size: 840px 700px;
}

.navbar {
  width: 100%;
  background-color: #555;
  overflow: auto;
}

.navbar a {
  float: left;
  padding: 12px;
  color: white;
  text-decoration: none;
  font-size: 17px;
  width: 25%;
  text-align: center;
}

.navbar a:hover {
  background-color: #000;
}

.navbar a.active {
  background-color: #4CAF50;
}

@media screen and (max-width: 500px) {
  .navbar a {
    float: none;
    display: block;
    width: 100%;
    text-align: left;
  }
}

</style>
<body>

<center>
<h2 style="color:white;">Welcome To Registration Page</h2>
</center>
<br><br>

<div class="navbar">

  <a href="register1">Register Here</a> 
  <a href="display">Display</a> 
  <a href="login">Login</a>
  <a href="find">Search</a>
</div>
<div>
</div>
</body>
</html> 
