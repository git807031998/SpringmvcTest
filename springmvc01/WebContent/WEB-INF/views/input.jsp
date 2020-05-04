<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath }/restcrud/emp" method="post" modelAttribute="employee">
<c:if test="${!empty employee.id }" var="flag">
<form:hidden path="id"/>
<input type="hidden" name="_method" value="put"/>
</c:if>


lastName:<form:input path="lastName"/><br/>
email:<form:input path="email"/><br/>
gender:<form:radiobuttons path="gender" items="${genders }"/><br/>
department:<form:select path="department.id" items="${depts }" 
itemLabel="departmentName" itemValue="id"></form:select>
<c:if test="${flag }">
<input type="submit" value="EDIT"/>
</c:if>

<c:if test="${!flag }">
<input type="submit" value="ADD"/>
</c:if>
</form:form>
</body>
</html>