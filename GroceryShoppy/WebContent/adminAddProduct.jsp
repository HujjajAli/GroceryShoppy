<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page import="groceryshoppy.ogs.dao.*" %>
<%@ page import="groceryshoppy.ogs.daoimplement.*" %>
<%@ page import="groceryshoppy.ogs.entity.*" %>
<%@ page import="java.util.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	
	ProductCategoryDAO pcdao = new ProductCategoryImplement();
	List<ProductCategory> categories =  pcdao.getAllCategory();
	request.setAttribute("categories", categories); 
   
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- JQuery Library -->
<script type="text/javascript" src="frontendstyle/js/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JavaScript Library -->
<script type="text/javascript" src="frontendstyle/js/bootstrap.min.js"></script>
<!-- Bootstrap CSS Library -->
<link rel="stylesheet" type="text/css" href="frontendstyle/css/bootstrap.min.css">

<title>Add Product| Grocery Shoppy</title>
</head>
<body>
<nav class="navbar navbar-inverse"><!-- Other Styeles default-->
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="index.jsp" class="navbar-brand">OGS System</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.jsp">Home</a></li>
				<li class="dropdown"><a href="index.jsp" class="dropdown-toggle" data-toggle="dropdown">Hujaj Ali <span class="caret"></span></a>
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
				<li><a href="index.jsp"><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
				<li><a href="#pros" data-toggle="collapse"><span class="glyphicon glyphicon-tasks"></span>Product</a>
					<ul id="pros" class="nav collapse">
						<li><a href="adminAddProduct.jsp"><div class="col-md-1"></div><span>Add New Product</span></a></li>
						<li><a href="adminAddProductsImages.jsp"><div class="col-md-1"></div><span>Add Product Images</span></a></li>
						<li><a href="adminShowProducts.jsp"><div class="col-md-1"></div><span>Show Products</span></a></li>	
					</ul>
				</li>
				<li><a href="adminShowSubscribers.jsp" ><span class="glyphicon glyphicon-edit"></span>Subscribers</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-pencil"></span> Orders</a></li>
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
			<form action="ProductCRUDController" method="POST">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<h1>Add New Product</h1>
					</div>
					<div class="panel-body">
						<div class="form-group row">
							<div class="col-md-3">
								<label>Product</label>
							</div>
							<div class="col-md-9">
								<input class="form-control" type="text" name="product" placeholder="Enter Product Name" required>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3">
								<label>Description</label>
							</div>
							<div class="col-md-9">
								<textarea rows="3" cols="15" name="discription" class="form-control" placeholder="Write Product Description"></textarea>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3">
								<label>Price</label>
							</div>
							<div class="col-md-9">
								<input class="form-control" type="number" name="price" placeholder="Enter Product Price" required>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3">
								<label>Discount</label>
							</div>
							<div class="col-md-9" >
								<input class="form-control" type="number" name="discount" placeholder="Enter Discount on Product " required>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3">
								<label>Company</label>
							</div>
							<div class="col-md-9">
								<input class="form-control" type="text" name="companey" placeholder="Enter Product Company" required>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3">
								<label>Category</label>
							</div>
							<div class="col-md-9" >
								<select name="productcategory" class="form-control" required>
									<option value="">Choose An Category</option>
									<c:forEach items="${categories}" var="cat">
										<option value="${cat.id}">${cat.cname}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3">
								<label>Type</label>
							</div>
							<div class="col-md-9" >
								<select name="type" class="form-control" required>
									<option value="">Choose An Type</option>
									<option value="veg">Vegetarian</option>
									<option value="nonveg">Non Vegetarian</option>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3">
								<label>Cuisine</label>
							</div>
							<div class="col-md-9">
								<select name="cuisine" class="form-control" required>
									<option value="">Choose a Cuisine Type</option>
									<option value="south american">South American</option>
									<option value="pakistani">Pakistani</option>
									<option value="indian">Indian</option>
									<option value="french">French</option>
									<option value="greek">Greek</option>
									<option value="chinese">Chinese</option>
									<option value="japanese">Japanese</option>
									<option value="italian">Italian</option>
									<option value="maxican">Mexican</option>
									<option value="thai">Thai</option>
									<option value="spanish">Spanish</option>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3">
								<label>Deal</label>
							</div>
							<div class="col-md-9" >
								<select name="deals" class="form-control" required>
									<option value="">Choose Deal Type</option>
									<option value="off">OFF</option>
									<option value="on">ON</option>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-4">
							</div>
							<div class="col-md-4">
								<input type="submit" name="action" class="form-control btn-success" value="Save Product">
							</div>
							<div class="col-md-4">
								<input type="reset" value="Reset"  class="form-control btn-success">
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<div class="alert alert-success text-uppercase fade in">
							<a href="#" class="close" data-dismiss="alert" area-label="close">&times;</a>${bookmsg}
						</div>
					</div>
				</div>
			</form>
		</div>
	
	</div>
</body>
</html>