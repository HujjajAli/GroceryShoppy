/*$(document).ready(function(){
	$(".showodetails").click(function(){
		$.ajax({
			type:"POST",
			url:"OrderAjaxController",
			data:"",
			success:function(data){
				$("#tabledata").html(data);
			}
		});
	});
}); **/

function showodetails(id){
	console.log("OK showodetails Fun Call "+id);
	$.ajax({
		type:"POST",
		url:"OrderAjaxController",
		data:"act=showorderdetails&id="+id,
		success:function(data){
			$("#tabledata").html(data);
		}
	});
}

function showcosorders(id){
	console.log("OK showcosorders Fun Call "+id);
	$.ajax({
		type:"POST",
		url:"OrderAjaxController",
		data:"act=customerorders&id="+id,
		success:function(data){
			$("#tabledata").html(data);
		}
	});
}