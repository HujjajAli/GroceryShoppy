<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 <%@ page import="groceryshoppy.ogs.dao.*" %>
 <%@ page import="groceryshoppy.ogs.daoimplement.*" %>
 <%@ page import="groceryshoppy.ogs.entity.*" %>
 <%@ page import="java.util.*" %>
 <%
 	OrderDAO od            = new OrderDaoImplement();
 	List<Cos_Order> orders = od.getAllOrders();
 	request.setAttribute("orders", orders);
 
 %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- JQuery Library -->
<script type="text/javascript" src="frontendstyle/js/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JavaScript Library -->
<script type="text/javascript" src="frontendstyle/js/bootstrap.min.js"></script>
<!-- Bootstrap CSS Library -->
<link rel="stylesheet" type="text/css" href="frontendstyle/css/bootstrap.min.css">

<script type="text/javascript" src="ajaxcalls/orderdetails.js"></script>
<style>
.showodetails{
}
</style>

<title>Customer Orders</title>
</head>
<body>
	<nav class="navbar navbar-inverse"><!-- Other Styeles default-->
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="index.jsp" class="navbar-brand">OGS System</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="adminindexpage.jsp">Home</a></li>
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
				<li><a href="#"><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
				<li><a href="#" data-toggle="collapse"><span class="glyphicon glyphicon-tasks"></span> Inventory</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-edit"></span> Subscribers</a></li>
				<li><a href="adminShowOrder.jsp"><span class="glyphicon glyphicon-pencil"></span> Orders</a></li>
				<li><a href="#" data-toggle="modal" data-target="#reportsModal"><span class="glyphicon glyphicon-tasks"></span> Order Reports</a></li>
				<li><a href="#" data-toggle="modal" data-target="#reportsModal"><span class="glyphicon glyphicon-tasks"></span> Inventory Reports</a></li>
				<li><a href="#" data-toggle="modal" data-target="#reportsModal"><span class="glyphicon glyphicon-tasks"></span> Subscriber Reports</a></li>
				<li><a href="#" data-toggle="modal" data-target="#reportsModal"><span class="glyphicon glyphicon-tasks"></span> System Reports</a></li>
				<li><a href="#" ><span class="glyphicon glyphicon-tasks"></span> Catogories</a></li>
				<li><a href="#" ><span class="glyphicon glyphicon-list"></span> Manage Admin</a></li>
			</ul>
		</div>
		
		<div class="col-md-9">
			<table class="table table-hover">
		<thead>
			<tr>
				<th>OrderID</th>
				<th>Costumer</th>
				<th>Bill</th>
				<th>Date</th>
				<th>Contact</th>
				<th>Status</th>
				<th>Address</th>
				<th>Detail</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${orders}" var="o">
			<tr>
				<td>ODR${o.id}</td>
				<td>${o.fname}</td>
				<td>${o.totalPrice}</td>
				<td>${o.costumeDate}</td>
				<td>${o.mobile}</td>
				<td>${o.status}</td>
				<td>${o.address}</td>
				<td><a href="#" class="btn btn-info" data-toggle="modal" data-target="#myModal" 
				       onclick="showodetails(${o.id})">View Details</a></td>
			</tr>
		</c:forEach>	
		</tbody>
	</table>
		</div>
	</div>
	
	
	<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Order Detail</h4>
      </div>
      <div class="modal-body">
        <table class="table table-condensed">
        	<thead>
				<tr>
					<th>Product</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>OrderID</th>
				</tr>
			</thead>
			<tbody id="tabledata">
				
			</tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

	<!-- Modal -->
<div id="reportsModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Report</h4>
      </div>
      <div class="modal-body">
      	<h4 class="text-info">Sorry No Report Created Yet</h4>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
     </div>
    </div>
 </div>
</body>
</html>