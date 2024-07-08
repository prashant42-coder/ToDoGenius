<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1>Todo Application</h1>
    <table class="table">
        <thead>
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Done?</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td><a href="delete-todo?id=${todo.id}" class="btn btn-delete">DELETE</a></td>
                    <td><a href="update-todo?id=${todo.id}" class="btn btn-update">UPDATE</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-add-todo">Add Todo</a>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

<!-- Add the following CSS code at the end of your HTML document -->
<style>
    /* Style for table headers */
    th {
        background-color: #f5f5f5;
        color: #333;
        font-weight: bold;
    }

    /* Style for table rows */
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    /* Style for delete and update buttons */
    .btn-delete,
    .btn-update {
        padding: 5px 10px;
        margin-right: 5px;
        border-radius: 5px;
    }

    .btn-delete {
        background-color: #ff6347; /* Tomato */
        border: none;
        color: white;
    }

    .btn-update {
        background-color: #4169e1; /* RoyalBlue */
        border: none;
        color: white;
    }

    /* Style for Add Todo button */
    .btn-add-todo {
        margin-top: 20px;
        padding: 10px 20px;
        border-radius: 5px;
        background-color: #32cd32; /* LimeGreen */
        border: none;
        color: white;
        text-decoration: none;
    }

    .btn-add-todo:hover {
        background-color: #228b22; /* ForestGreen */
    }
</style>
</body>
</html>
