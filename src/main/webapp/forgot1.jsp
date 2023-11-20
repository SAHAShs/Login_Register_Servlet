<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reset here</title>
<style>
body {
	font-family: Arial, sans-serif;
	display: grid;
	justify-content: center;
}

.header {
	display: flex;
	justify-content: center;
	font-size: 4rem;
	font-weight: bolder;
	color: #289cc0;
	margin-top: 100px;
	align-content: center;
}

.form {
	margin: 0px 0px 0px 50px;
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

a {
	text-decoration: none;
	color: #289cc0;
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

.warning {
	color: red;
}
</style>
</head>
<body>
	<div class="login" id="login">
		<form class="form" id="form1" action="Forgot" method="POST">
			<span class="header">Forgot Password</span>
			<div class="form-grid">
				<div>
					<label for="emailorPhone">Enter Registered Email</label> <input
						type="text" id="email" name="email" required
						placeholder="Enter email"
						pattern="[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$">
				</div>
			</div>
			<div class="form-grid1">
				<button type="submit" value="save" name="register">Continue</button>
			</div>
			<div>
				<%
				String errorMessage = (String) request.getAttribute("errormsg");
				if (errorMessage != null && !errorMessage.isEmpty()) {
				%>
				<span class="warning"><%=errorMessage%></span>
				<%
				}
				%>
			</div>
		</form>
	</div>
</body>
</html>