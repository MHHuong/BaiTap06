<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><meta charset="UTF-8"><title>User Detail</title></head>
<body>
<h2>User Detail</h2>
<p><b>ID:</b> ${user.id}</p>
<p><b>Username:</b> ${user.username}</p>
<p><b>Full name:</b> ${user.fullName}</p>
<p><b>Email:</b> ${user.email}</p>
<p><b>Active:</b> <c:out value="${user.active}"/></p>

<p><a href="<c:url value='/admin/users'/>">Back</a></p>
</body>
</html>