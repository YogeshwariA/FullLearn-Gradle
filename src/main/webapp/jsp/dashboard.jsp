<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/dashboard.js"></script>
<title>Full Learn</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />
<!-- Bootstrap Styles-->
<link href="css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="css/font-awesome.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="css/custom-styles.css" rel="stylesheet" />

<!-- Google Fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<jsp:useBean id="user" scope="session" class="com.fulllearn.model.User"></jsp:useBean>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
			<div class="navbar-header">
				<a class="navbar-brand waves-effect waves-dark"
					class="large material-icons" href="#"><strong><img
						align="left" src="images/fav-icon.png">FullLearn</strong></a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#"
					class="dropdown-toggle dropdown-button waves-effect waves-dark"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><img class="img" id="profilePic"
						src="${user.photoId}"></img> <b>${user.firstName}</b> <i
						class="material-icons right">arrow_drop_down</i></a>
					<ul class="dropdown-menu">
						<li><a href="/logout">Logout</a></li>
					</ul></li>
			</ul>
		</nav>

		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li><a id="dashboard" href="javascript:showDashboard()"
						class="active-menu waves-effect waves-dark"><i
							class="fa fa-dashboard"></i>Dashboard</a></li>
				</ul>
			</div>
		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div class="header"></div>
			<div id="page-inner" style="height:500px">
				<div class="dashboard-cards">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-5 full-card-center">
							<div class="card horizontal cardIcon waves-effect waves-dark">
								<div id="color_for_overview" class="card-stacked">
									<div class="card-content">
										<h3>Overview</h3>
									</div>
									<div class="row learn-overview">
										<div id="change_color_4" class="card-action col-md-6">
											<h4>Four week avg:</h4>
											<img class="loader" id="loader_avg_4" src="images/loader.gif"></img>
											<div id="error_avg_4"></div>
											<strong id="fourWeekAvg"></strong>
										</div>
										<div id="change_color_12" class="card-action col-md-6">
											<h4>Twelve week avg:</h4>
											<img class="loader" id="loader_avg_12" src="images/loader.gif"></img>
											<div id="error_avg_12"></div>
											<strong id="twelveWeekAvg"></strong>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
						<div class="col-xs-12 col-sm-6 col-md-4">
							<div class="card horizontal cardIcon waves-effect waves-dark">
								<div id="color_for_0" class="card-stacked">
									<div class="card-content">
										<h3>This week</h3>
									</div>
									<div class="card-action full-card-lg-action">
										<img class="loader" id="loader_0" src="images/loader.gif"></img>
										<div id="error-0"></div>
										<div id="date-0"></div>
										<div class="change_time_div">
											<strong id="change_time_0"></strong>
										</div>
										<ul class="full-left-align" id="challenge_details_0">

										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 ">
							<div class="card horizontal cardIcon waves-effect waves-dark">
								<div id="color_for_4" class="card-stacked">
									<div class="card-content">
										<h3>Four weeks</h3>
									</div>
									<div class="card-action full-card-lg-action">
										<img class="loader" id="loader_4" src="images/loader.gif"></img>
										<div id="error-4"></div>
										<div id="date-4"></div>
										<div class="change_time_div">
											<strong id="change_time_4"></strong>
										</div>
										<ul class="full-left-align" id="challenge_details_4">

										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4">
							<div class="card horizontal cardIcon waves-effect waves-dark">
								<div id="color_for_12" class="card-stacked">
									<div class="card-content">
										<h3>Twelve weeks</h3>
									</div>
									<div class="card-action full-card-lg-action">
										<img class="loader" id="loader_12" src="images/loader.gif"></img>
										<div id="error-12"></div>
										<div id="date-12"></div>
										<div class="change_time_div">
											<strong id="change_time_12"></strong>
										</div>
										<ul class="full-left-align" id="challenge_details_12">

										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
</body>
</html>
