<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Todo's for ${name_key}</title>
    <link href="webjars/bootstrap/4.0.0/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h1>Your Todo's</h1>
<br>
<table class="table table-striped">
    <thead>
    <tr>
        <td>Description</td>
        <td>Target Date</td>
        <td>is Done?</td>
        <td>Delete</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${todos}" var="todo">
        <tr>
            <td>${todo.desc}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
            <td>
            <a type="button" class="btn btn-warning"
               href="/delete-todo?id=${todo.id}">Delete</a>
            </td>
            <td>
                <a type="button" class="btn btn-success"
                   href="/update-todo?id=${todo.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<br>
<a class="button" href="/add-todo">Add a todo</a>
<br>


</div>

<script src="webjars/jquery/3.0.0/jquery.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.js"></script>

</body>
</html>