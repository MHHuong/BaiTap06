<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><meta charset="UTF-8"><title>Videos</title></head>
<body>
<h2>Videos</h2>

<a href="<c:url value='/admin/videos/add'/>">Add Video</a>

<form method="get" action="<c:url value='/admin/videos/search'/>" style="margin:10px 0;">
    <input type="text" name="q" value="${param.q}" placeholder="Search title..."/>
    <button type="submit">Search</button>
</form>

<c:if test="${not empty page and not empty page.content}">
    <table border="1" cellpadding="6" cellspacing="0">
        <tr>
            <th>ID</th><th>Title</th><th>URL</th><th>Active</th><th>Action</th>
        </tr>
        <c:forEach items="${page.content}" var="v">
            <tr>
                <td>${v.id}</td>
                <td>${v.title}</td>
                <td><a href="${v.url}" target="_blank">${v.url}</a></td>
                <td><c:out value="${v.active}"/></td>
                <td>
                    <a href="<c:url value='/admin/videos/view/${v.id}'/>">View</a> |
                    <a href="<c:url value='/admin/videos/edit/${v.id}'/>">Edit</a> |
                    <a href="<c:url value='/admin/videos/delete/${v.id}'/>">Delete</a>
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
    <p>Không có video.</p>
</c:if>

</body>
</html>