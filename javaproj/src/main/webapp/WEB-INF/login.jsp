<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isErrorPage="true"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<p class="tip">S.O.A.R</p>
	<div class="cont">
		<div class="form sign-in">
			<h2>Welcome back,</h2>
			<form:form action="login" method="POST" modelAttribute="newLogin">
				<label> <span>Email</span> <form:input path="emailLog"
						type="email" /> <form:errors path="emailLog" class="text-warning" />
				</label>
				<label> <span>Password</span> <form:password path="pass" />
					<form:errors path="pass" class="text-warning" />
				</label>
				<p class="forgot-pass">Forgot password?</p>
				<button class="submit">Sign In</button>
				<button class="fb-btn">
					Connect with <span>gmail</span>
				</button>
			</form:form>
		</div>
		<div class="sub-cont">
			<div class="img">
				<div class="img__text m--up">
					<h2>New here?</h2>
					<p>Sign up and discover great amount of new opportunities!</p>
				</div>
				<div class="img__text m--in">
					<h2>One of us?</h2>
					<p>If you already have an account, just sign in. We've missed
						you!</p>
				</div>
				<div class="img__btn">
					<span class="m--up">Sign Up</span> <span class="m--in">Sign
						In</span>
				</div>
			</div>
			<div class="form sign-up">
				<h2>Adopt pets, save lives,</h2>
				<form:form action="register" method="POST" modelAttribute="newUser">
					<label> <span>Name</span> <form:input path="userName" />
						<form:errors path="userName" class="text-warning" />
					</label>
					<label> <span>Email</span> <form:input path="email"
							type="email" /> <form:errors path="email" class="text-warning" />
					</label>
					<label> <span>Password</span> <form:password
							path="password" /> <form:errors path="password"
							class="text-warning" />
					</label>
					<label> <span>Confirm Password</span> <form:password
							path="confirm" /> <form:errors path="confirm"
							class="text-warning" />
					</label>
					<button class="submit">Sign Up</button>
					<!-- <button  class="fb-btn">Join with <span>gmail</span></button> -->
				</form:form>
			</div>
		</div>
	</div>




	<!--   <div class="video">
      <video width="320" height="240" controls>
        <source src="/static/video/MyVideo.mp4" type="video/mp4">
      </video>
      <div class="video__text m--up">
        <h2>New here?</h2>
        <p>Sign up and discover a great amount of new opportunities!</p>
      </div>
      <div class="video__text m--in">
        <h2>One of us?</h2>
        <p>If you already have an account, just sign in. We've missed you!</p>
      </div>
      <div class="video__btn">
        <span class="m--up">Sign Up</span>
        <span class="m--in">Sign In</span>
      </div>
    </div> -->

	<a href="https://dribbble.com/shots/3306190-Login-Registration-form"
		target="_blank" class="icon-link"> <img
		src="http://icons.iconarchive.com/icons/uiconstock/socialmedia/256/Dribbble-icon.png"
		alt="Dribbble">
	</a>
	<!-- <a href="https://codepen.io/suez/pen/XWyBpre" target="_blank" class="link-footer">New 2023 Version</a> -->
	<a href="https://twitter.com/NikolayTalanov" target="_blank"
		class="icon-link icon-link--twitter"> <img
		src="https://cdn1.iconfinder.com/data/icons/logotypes/32/twitter-128.png"
		alt="Twitter">
	</a>

	<script>
		document.addEventListener('DOMContentLoaded', function() {
			document.querySelector('.img__btn').addEventListener(
					'click',
					function() {
						document.querySelector('.cont').classList
								.toggle('s--signup');
					});
		});
	</script>

</body>
</html>
