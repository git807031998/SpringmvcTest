<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../scripts/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".del").click(function(){
		//alert("----------");
		var flag = window.confirm("delete ?yes or no");
		if(!flag){
			return false;
		}
		
		var href = $(this).attr("href");
		$("form").attr("action",href).submit();
		return false;
		
		
	});
})
</script>
</head>
<body>

<h1 align="center">EMPS INFO</h1>
<form action="" method="post" >
	<input type="hidden" name="_method" value="delete"/>
</form>
<table border="1px" align="center" width="70%" cellspacing="0px">
	<tr>
		<th>Id</th>
		<th>LastName</th>
		<th>Email</th>
		<th>Gender</th>
		<th>DeptName</th>
		<th>Operation</th>
	</tr>
	<!-- 通过迭代模型数据，生成表格 -->
		<c:forEach items="${emps }" var="emp">
			<tr align="center">
				<td>${emp.id }</td>
				<td>${emp.lastName }</td>
				<td>${emp.email }</td>
				<td>${emp.gender==0?"female":"male"}</td>
				<td>${emp.department.departmentName }</td>
				<td>
				<a href="emp/${emp.id }">EDIT</a>
				<a class="del" href="emp/${emp.id }">DELETE</a>
				</td>
			</tr>
		</c:forEach>

</table>
<h2 align="center"><a href="emp">Add New Emp</a></h2>
	
</body>



</html>