<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
#container {
	width: 800px;
	height: 500px;
	border: 2px solid red;
}
</style>

<script>
	function display(data) {
		Highcharts.chart('container', {
		   
		    xAxis: {
		        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'
		            ]
		    },
		    yAxis: {
		    	max:200,
		        title: {
		        	
		            text: 'Temperature'
		        }
		       
		    },
		    tooltip: {
		        crosshairs: true,
		        shared: true
		    },
		    plotOptions: {
		        spline: {
		            marker: {
		                radius: 4,
		                lineColor: '#666666',
		                lineWidth: 1
		            }
		        }
		    },
		    series:data,
		    
		    

		});
	}


	function getData() {
		
		$.ajax({
			url:'getdata1.mc',
			success:function(data){
				//alert(okok);
				display(data);
			},
			error:function(){
				alert(123);
				}
			
		});
		//display();
	};
	$(document).ready(function(){
	      getData();
	});
	
</script>

<h1>chart1</h1>
<div id="container"></div>