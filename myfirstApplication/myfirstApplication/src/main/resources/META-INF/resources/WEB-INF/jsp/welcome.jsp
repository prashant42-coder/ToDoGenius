<html>
	<head>
		<title>Welcome Page</title>
	</head>
	<body>
		<%@ include file="common/header.jspf" %>	
        <%@ include file="common/footer.jspf" %>
		<%@ include file="common/navigation.jspf" %>	
<div class="container">
		<h1>Welcome ${name}</h1>
		
		<a href="list-todos">Manage</a> your todos
		</div>
	</body> 

</html>