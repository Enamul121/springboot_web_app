<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Todo's for ${name_key}</title>
</head>
<body>

<h1>Your Todo's</h1>
<br>
<table>
    <thead>
    <tr>
        <td>Description</td>
        <td>Target Date</td>
        <td>is Done?</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${todos}" var="todo">
        <tr>
            <td>${todo.desc}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<br>
<a href="/add-todo">Add a todo</a>
</body>
</html>