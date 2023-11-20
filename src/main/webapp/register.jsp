<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style>
body {
	font-family: Arial, sans-serif;
	display: grid;
	justify-content: center;
}

.header {
	display: flex;
	justify-content: center;
	font-size: 3rem;
	font-weight: bolder;
	color: #289cc0;
	margin: 50px 0px 50px 0px;
	align-content: center;
}

.form {
	width: auto;
}

.form-grid1 {
	display: flex;
	gap: 20px;
	margin-bottom: 10px;
}

label {
	display: block;
	margin-bottom: 10px;
	margin-top: 10px;
}

input {
	width: 100%;
	padding: 8px 0px 8px 8px;
	border: 1px solid #ffffff;
	border-radius: 5px;
	outline: none;
}

input:invalid {
	border: 1px solid rgb(255, 0, 0);
}

input:valid {
	border: 1px solid rgb(106, 255, 0);
}

button {
	margin-top: 10px;
	padding: 13px 20px;
	background-color: rgb(0, 0, 0);
	color: rgb(255, 255, 255);
	border: none;
	border-radius: 5px;
	cursor: pointer;
	width: fit-content;
}

button[type="submit"]:hover, button[type="button"]:hover {
	background-color: #289cc0;
	color: #ffffff;
}

button:active {
	scale: 0.8;
}

a {
	text-decoration: none;
	color: #289cc0;
}

.warning {
	color: red;
	font-size: 1rem;
}
</style>
</head>
<body>
	<span class="header">Register here</span>
	<div class="reg" id="reg">
		<form class="form" id="form1" action="register" method="POST">
			<div class="form-grid">
				<div>
					<label for="fullName">Full Name</label> <input type="text"
						id="fullName" name="fullName" required placeholder="Fullname"
						pattern="[a-zA-Z ]{1,}">
				</div>
				<div>
					<label for="password">Password</label> <input type="password"
						id="password" name="password" required placeholder="password"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}">
				</div>
				<div>
					<label for="phoneNumber">Phone Number</label> <input type="text"
						id="phoneNumber" name="phoneNumber" placeholder="6666699999"
						pattern="[0-9]{10,10}">
				</div>
				<div>
					<label for="email">Email</label> <input type="email" id="email"
						name="email" required placeholder="email@gmail.com">
				</div>
			</div>
			<div class="form-grid1">
				<button type="submit" value="save" name="register">Register</button>
				<%
				String errorMessage = (String) request.getAttribute("errormsg");
				if (errorMessage != null && !errorMessage.isEmpty()) {
				%>
				<span class="warning"><%=errorMessage%></span>
				<%
				}
				%>
			</div>
			<a href="index.jsp">Already a user?</a>
		</form>
	</div>
</body>
</html>