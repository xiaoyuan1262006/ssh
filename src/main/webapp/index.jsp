<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h2>Hello World!</h2>
<form action="myController" method="post">
    <input name="name">
    return:<%=request.getAttribute("name")%>
    <input value="提交" type="submit">
</form>

</body>

</html>
