<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>addCar page</title>
</head>
<body>


<p> RowAdded</p><c:out value ="${rowAdded}"/>

<form:form method = "get" action = "command">

<form:label path ="carnumber">CarData car number</form:label>
<form:input path ="carnumber"/>

<form:label path ="model">CarData  model</form:label>
<form:input path ="model"/>

<form:label path ="year_of_manufacturer">CarData year_of_manufacturer</form:label>
<form:input path ="year_of_manufacturer"/>

<form:label path ="kilometers_travelled">CarData kilometers_travelled</form:label>
<form:input path ="kilometers_travelled"/>

<form:label path ="owner_name">CarData owner_name</form:label>
<form:input path ="owner_name"/>

<form:label path ="status">CarData status</form:label>
<form:input path ="status"/>


<input type ="submit" value ="Add">
</form:form>
</body>
</html>