<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><meta charset="UTF-8"><title>Users</title></head>
<body>
<h2>Users</h2>

<a href="<c:url value='/admin/users/add'/>">Add User</a>

<form method="get" action="<c:url value='/admin/users/search'/>" style="margin:10px 0;">
    <input type="text" name="q" value="${param.q}" placeholder="Search username..."/>
    <button type="submit">Search</button>
</form>

<c:if test="${not empty page and not empty page.content}">
    <table border="1" cellpadding="6" cellspacing="0">
        <tr>
            <th>ID</th><th>Username</th><th>Full name</th><th>Email</th><th>Active</th><th>Action</th>
        </tr>
        <c:forEach items="${page.content}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.username}</td>
                <td>${u.fullName}</td>
                <td>${u.email}</td>
                <td><c:out value="${u.active}"/></td>
                <td>
                    <a href="<c:url value='/admin/users/view/${u.id}'/>">View</a> |
                    <a href="<c:url value='/admin/users/edit/${u.id}'/>">Edit</a> |
                    <a href="<c:url value='/admin/users/delete/${u.id}'/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div style="margin-top:8px;">
        Page ${page.number + 1} / ${page.totalPages}
        <c:if test="${!page.first}">
            <a href="?page=${page.number-1}&size=${page.size}&q=${param.q}">Prev</a>
        </c:if>
        <c:if test="${!page.last}">
            <a href="?page=${page.number+1}&size=${page.size}&q=${param.q}">Next</a>
        </c:if>
    </div>
</c:if>

<c:if test="${empty page or empty page.content}">
    <p>Không có người dùng.</p>
</c:if>

</body>
</html>