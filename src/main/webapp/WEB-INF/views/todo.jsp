<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add Todo</title>

    <link href="webjars/bootstrap/4.0.0/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<div class="container">




<h1>Todo Add..................</h1>
<br>
 <!--Add todo: for ${name_key} -- -->

<br>


<form:form method="post"  modelAttribute="todo">
<fieldset>
    <form:hidden path="id"></form:hidden>
    <form:label class="form-group" path="desc">Description</form:label>
    <form:input type="text" name="desc" path="desc" class="form-control" required="required" />
    <form:errors path="desc" cssClass="text-warning"/>
</fieldset>
<br>
    <button type="submit" class="btn btn-success">Add</button>
</form:form>
</div>


<script src="webjars/jquery/3.0.0/jquery.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.js"></script>


</body>
</html>