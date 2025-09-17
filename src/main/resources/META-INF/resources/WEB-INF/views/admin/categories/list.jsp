<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html><head><meta charset="UTF-8"><title>Categories</title></head>
<body>
<h2>Categories</h2>
<a href="<c:url value='/admin/categories/add' />">Add</a>
<form method="get" action="<c:url value='/admin/categories/search' />">
    <input type="text" name="name" value="${param.name}" placeholder="Search name..."/>
    <button type="submit">Search</button>
</form>

<c:if test="${not empty page and not empty page.content}">
    <table border="1" cellpadding="6">
        <tr><th>ID</th><th>Name</th><th>Action</th></tr>
        <c:forEach items="${page.content}" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.categoryName}</td>
                <td>
                    <a href="<c:url value='/admin/categories/view/${c.id}'/>">View</a> |
                    <a href="<c:url value='/admin/categories/edit/${c.id}'/>">Edit</a> |
                    <a href="<c:url value='/admin/categories/delete/${c.id}'/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div>
        Page ${page.number+1} / ${page.totalPages}
        <c:if test="${!page.first}">
            <a href="?page=${page.number-1}&size=${page.size}">Prev</a>
        </c:if>
        <c:if test="${!page.last}">
            <a href="?page=${page.number+1}&size=${page.size}">Next</a>
        </c:if>
    </div>
</c:if>

<c:if test="${empty page or empty page.content}">
    <p>Không có dữ liệu.</p>
</c:if>
</body></html>