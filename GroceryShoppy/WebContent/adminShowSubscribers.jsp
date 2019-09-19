<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 <%@ page import="groceryshoppy.ogs.dao.*" %>
 <%@ page import="groceryshoppy.ogs.daoimplement.*" %>
 <%@ page import="groceryshoppy.ogs.entity.*" %>
 <%@ page import="java.util.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- JQuery Library -->
<script type="text/javascript" src="frontendstyle/js/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JavaScript Library -->
<script type="text/javascript" src="frontendstyle/js/bootstrap.min.js"></script>
<!-- Bootstrap CSS Library -->
<link rel="stylesheet" type="text/css" href="frontendstyle/css/bootstrap.min.css">

<title>Show Subscribers</title>

<%CostumerDAO cdao = new CostumerDaoImplement(); 
  List<Costumer> costumers = cdao.getAllCostumers();
  request.setAttribute("costumers", costumers);
  ProductCategoryDAO pcdao = new ProductCategoryImplement();
  List<ProductCategory> categories = pcdao.getAllCategory();
  request.setAttribute("categories", categories);
%>
</head>
<body>
	<nav class="navbar navbar-inverse"><!-- Other Styeles default-->
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="adminIndexPage.jsp" class="navbar-brand">OGS System</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.jsp">Home</a></li>
				<li class="dropdown"><a href="index.jsp" class="dropdown-toggle" data-toggle="dropdown">Nasir Hussain <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a>Profile</a></li>
						<li><a>Logout</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="col-md-3">
			<ul class="navbar navbar-default nav" style="height:100vh">
				<li><a href="adminIndexPage.jsp"><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
				<li><a href="#pros" data-toggle="collapse"><span class="glyphicon glyphicon-tasks"></span>Product</a>
					<ul id="pros" class="nav collapse">
						<li><a href="adminAddProduct.jsp"><div class="col-md-1"></div><span>Add New Product</span></a></li>
						<li><a href="adminAddProductsImages.jsp"><div class="col-md-1"></div><span>Add Product Images</span></a></li>
						<li><a href="#"><div class="col-md-1"></div><span>Edit Product</span></a></li>	
					</ul>
				</li>
				<li><a href="#"><span class="glyphicon glyphicon-edit"></span>Subscribers</a></li>
				<li><a href="adminShowOrder.jsp"><span class="glyphicon glyphicon-pencil"></span> Orders</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-list"></span>Manage Admin</a></li>
				<li><a href="#cats" data-toggle="collapse"><span class="glyphicon glyphicon-tasks"></span>Catogories</a>
					<ul id="cats" class="nav collapse">
						<li><a href="adminShowProducts.jsp"><div class="col-md-1"></div><span>Show All Products</span></a></li>
						<c:forEach items="${categories}" var="c">
						<li><a href="#"><div class="col-md-1"></div><span>${c.cname}</span></a></li>
						</c:forEach>	
					</ul>
				</li>
			</ul>
		</div>
		
		<div class="col-md-9">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<h1>All Costumers</h1>
					</div>
					<div class="panel-body">
						<table class="table table-hover">
							<tr>
								<th>ID</th>
								<th>NAME</th>
								<th>EMAIL</th>
								<th>PASSWORD</th>
								<th>EDIT</th>
								<th>REMOVE</th>
							</tr>
							<c:forEach items="${costumers}" var="c">
							<tr>
								<td>${c.id}</td>
								<td>${c.cosName}</td>
								<td>${c.email}</td>
								<td>${c.password}</td>
								<td><button class="btn">Update</button></td>
								<td><button class="btn">Delete</button></td>
							</tr>
							</c:forEach>
						</table>
					</div>
				</div>
		</div>
					
	</div>
</body>
</html>