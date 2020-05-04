<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="hello">hello springmvc</a>
<a href="testClass/testMethodParam?username=1&age=2">test param</a>

<br />

<a href="testClass/testMethodPath/color/red">test rest</a>
<form action="testClass/testMethod" method="post">
<input type="submit" value="post">
</form>



<a href="order/1001">rest get</a>
<br/>
<form action="order/1001" method="post">
<input type="hidden" name="_method" value="delete"/>
<input type="submit" value="rest delete"/>
</form>

<br/>


<form action="order" method="post">
	<input type="submit" value="rest post"/>
</form>

<form action="order" method="post">
<input type="hidden" name="_method" value="put"/>
<input type="submit" value="rest put" />
</form>



--------------------------------------------
<br/>



<a href="testClass/testrequestparam?username=1&age=2&sex=f">test reqparam</a>


-----------------------------
<br/>



<form action="testClass/testUser" method="post">
username:<input type="text" name="username"/><br/>
password:<input type="password" name="password"/><br/>
email:<input type="text" name="email"/><br/>
gender:man <input type="radio" name="gender" value="1" /><br/>
woman <input type="radio" name="gender" value="0" /><br/>
province:<input type="text" name="address.province" /><br/>
city:<input type="text" name="address.city"/>
<input type="submit" value="sub"/>
       
</form>


<a href="testClass/testservletapi">test servletapi</a>



------------------------------------------------
<br/>
<a href="testmodelandview">test modelandview</a>
<br/>


---------------------------------------------------
<br />

<form action="testClass/upload" method="post" enctype="multipart/form-data">

	upload desc:<input type="text" name="desc" /><br/>
	upload file:<input type="file" name="uploadfile" />
	<input type="submit" value="upload"/>
</form>

</body>
</html> 