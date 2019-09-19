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

<%ProductCategoryDAO pcdao = new ProductCategoryImplement();
  ProductDAO         pdao  = new ProductImplement();  

  List<ProductCategory> categories = pcdao.getAllCategory();
  List<Product>        products   = pdao.getAllProducts();
  
  request.setAttribute("products", products);
  request.setAttribute("categories", categories);
%>

<!-- JQuery Library -->
<script type="text/javascript" src="frontendstyle/js/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JavaScript Library -->
<script type="text/javascript" src="frontendstyle/js/bootstrap.min.js"></script>
<!-- Bootstrap CSS Library -->
<link rel="stylesheet" type="text/css" href="frontendstyle/css/bootstrap.min.css">

<title>Add Product Images| Grocery Shoppy System</title>
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
						<li><a href="#"><div class="col-md-1"></div><span>Edit Product</span></a></li>	
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
						<h1>Add Images</h1>
					</div>
					<div class="panel-body">
						<div class="form-group row">
							<div class="col-md-3">
								<label>Product</label>
							</div>
							<div class="col-md-9">
								<select name="product" class="form-control" required>
									<c:forEach items="${products}" var="p">
										<option value="${p.proId}">${p.name}</option>
									</c:forEach>	
								</select>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3">
								<label>Main Image</label>
							</div>
							<div class="col-md-9">
								<input class="form-control" type="text" name="image" placeholder="Enter Main Image" required>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3">
								<label>Deals Image</label>
							</div>
							<div class="col-md-9">
								<input class="form-control" type="text" name="dealimg" placeholder="Enter Deals Image" required>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3">
								<label>Image 1</label>
							</div>
							<div class="col-md-9">
								<input class="form-control" type="text" name="img_one" placeholder="Enter Image 1" required>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3">
								<label>Image 2</label>
							</div>
							<div class="col-md-9">
								<input class="form-control" type="text" name="img_two" placeholder="Enter Image 2" required>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3">
								<label>Image 3</label>
							</div>
							<div class="col-md-9">
								<input class="form-control" type="text" name="img_three" placeholder="Enter Image 3" required>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-4">
							</div>
							<div class="col-md-4">
								<input type="submit" name="action" class="form-control btn-success" value="Save Images">
							</div>
							<div class="col-md-4">
								<input type="reset" value="Reset"  class="form-control btn-success">
							</div>
						</div>
						<div class="panel-footer">
						<div class="alert alert-success text-uppercase fade in">
							<a href="#" class="close" data-dismiss="alert" area-label="close">&times;</a>${bookmsg}
						</div>
					</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>