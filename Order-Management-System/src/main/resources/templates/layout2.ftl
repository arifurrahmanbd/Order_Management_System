<!DOCTYPE html>
<html lang="en" ng-app="manager">
<head>
<title>Common Spring</title>
</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<div th:include="theme_includes/main-header" th:remove="tag" />
		<!-- Left side column. contains the logo and sidebar -->

		<div layout:fragment="main-sidebar" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div th:include="theme_includes/content-header" th:remove="tag" />
			<!-- <div th:include="dashboard/dashboard_content" th:remove="tag" /> -->
			<section class="content" layout:fragment="content"></section>
		</div>
		<!-- /.content-wrapper -->
		<div th:include="theme_includes/main-footer" th:remove="tag" />

		<div th:include="theme_includes/control-sidebar" th:remove="tag" />

		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

</body>
</html>