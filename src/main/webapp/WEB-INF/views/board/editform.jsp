<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>


<h1>Edit Form</h1>
<form:form modelAttribute = "u" action="../editok" method="post">
<input type="hidden" name="seq" value= "${u.seq}"/>
<table>
    <tr><td>Category:</td><td><form:input path="category"/></td></tr>
    <tr><td>Title:</td><td><form:input path="title"/></td></tr>
    <tr><td>Writer:</td><td><form:input path="writer"/></td></tr>
    <tr><td>Content:</td><td><form:textarea cols="50" rows="5" path="content"/></td></tr>
</table>
    <input type="submit" value="Edit"/>
    <input type="button" value="Cancel" onclick="history.back()"/>
</form:form>

</body>
</html>