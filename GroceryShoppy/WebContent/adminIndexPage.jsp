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
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard || Shoppy Grocery </title>

<!-- JQuery Library -->
<script type="text/javascript" src="frontendstyle/js/jquery-3.2.1.min.js"></script>
<!-- Bootstrap JavaScript Library -->
<script type="text/javascript" src="frontendstyle/js/bootstrap.min.js"></script>
<!-- Bootstrap CSS Library -->
<link rel="stylesheet" type="text/css" href="frontendstyle/css/bootstrap.min.css">

<script type="text/javascript" src="ajaxcalls/orderdetails.js"></script>
<%
	OrderDAO     od             = new OrderDaoImplement();
	CostumerDAO  cos_dao        = new CostumerDaoImplement();
	ProductDAO   pdao           = new ProductImplement();
	List<Cos_Order> orders      = od.getAllOrders();
	List<Costumer>  subscribers = cos_dao.getAllCostumers();
	
	request.setAttribute("orders", orders);
	request.setAttribute("subscribers", subscribers);
	
	Object loginUser = request.getSession().getAttribute("loginadminses");
	Admin user = null;
	String userVal = "";
	if(loginUser == null){
		user = null;
		userVal = "userNotOK";
		request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
	}else{
		userVal = "userOk";
		user = (Admin)loginUser;
	}
	
%>
</head>
<body>
	<nav class="navbar navbar-inverse"><!-- Other Styeles default-->
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="index.jsp" class="navbar-brand">OGS System</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Home</a></li>
				<li class="dropdown"><a href="index.jsp" class="dropdown-toggle" data-toggle="dropdown"><%=user.getAdmin() %> <span class="caret"></span></a>
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
			<div class="row">
				<div class="col-md-4">
					<div class="panel panel-danger">
						<div class="panel-heading">
							<div class="row">
								<div class="col-md-3">
									<span class="glyphicon glyphicon-signal" style="font-size:4.5em"></span>
								</div>
								<div class="col-md-9 text-right" >
									<div style="font-size:2.5em"><%=od.getOrderCount()%></div>
									<div style="font-size:1.4em">Orders</div>
								</div>
							</div>
						</div>
				    
						<a href="adminShowOrder.jsp">
							<div class="panel-footer">
								<div class="pull-left">View Orders</div>
								<div class="pull-right glyphicon glyphicon-circle-arrow-right"><span></span></div>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="panel panel-danger">
						<div class="panel-heading">
							<div class="row">
								<div class="col-md-3">
									<span class="glyphicon glyphicon-signal" style="font-size:4.5em"></span>
								</div>
								<div class="col-md-9 text-right" >
									<div style="font-size:2.5em"><%=pdao.getProductCount()%></div>
									<div style="font-size:1.4em">Products</div>
								</div>
							</div>
						</div>
				    
						<a href="adminShowProducts.jsp">
							<div class="panel-footer">
								<div class="pull-left">View Inventory</div>
								<div class="pull-right glyphicon glyphicon-circle-arrow-right"><span></span></div>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-4">
					<div class="panel panel-danger">
						<div class="panel-heading">
							<div class="row">
								<div class="col-md-3">
									<span class="glyphicon glyphicon-signal" style="font-size:4.5em"></span>
								</div>
								<div class="col-md-9 text-right" >
									<div style="font-size:2.5em"><%=cos_dao.getCustomerCount()%></div>
									<div style="font-size:1.4em">Subscribers</div>
								</div>
							</div>
						</div>
				    
						<a href="adminShowSubscribers.jsp">
							<div class="panel-footer">
								<div class="pull-left">View Subscribers</div>
								<div class="pull-right glyphicon glyphicon-circle-arrow-right"><span></span></div>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Customer Orders</h4>
					</div>
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>ORD-ID</th>
									<th>OWNER</th>
									<th>STATUS</th>
									<th>TOTAL</th>
									<th>CONTACT</th>
									<th>DATE</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${orders}" var="o" begin="0" end="4">
								<tr>
									<td>ODR${o.id}</td>
									<td>${o.fname}</td>
									<td>${o.status}</td>
									<td>${o.totalPrice}</td>
									<td>${o.mobile}</td>
									<td>${o.costumeDate}</td>
									<td><a href="#" class="btn btn-info">Delivered</a></td>
								</tr>
							</c:forEach>	
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Subscribers</h4>
					</div>
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th> ID </th>
									<th>Name</th>
									<th>Email</th>
									<th>Orders</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${subscribers}" var="s">
								<tr>
									<td>${s.id}</td>
									<td>${s.cosName}</td>
									<td>${s.email}</td>
									<td><a href="#" class="btn btn-info" data-toggle="modal" data-target="#cusOrders" onclick="showcosorders(${s.id})">Orders</a></td>
									<td><a href="#" class="btn btn-info">Delete</a></td>
								</tr>
							</c:forEach>	
							</tbody>
						</table>
					</div>
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
 
 	<!-- Modal -->
<div id="cusOrders" class="modal fade " role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Report</h4>
      </div>
      <div class="modal-body">
      	<table class="table table-hover">
      		<thead>
			<tr>
				<th>OrderID</th>
				<th>Name</th>
				<th>Bill</th>
				<th>Date</th>
				<th>Contact</th>
				<th>Status</th>
				<th>Address</th>
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
</body>
</html>