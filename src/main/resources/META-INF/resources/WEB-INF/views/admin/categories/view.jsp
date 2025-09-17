<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html><head><meta charset="UTF-8"><title>View Category</title></head>
<body>
<h2>Category Detail</h2>
<p>ID: ${category.id}</p>
<p>Name: ${category.categoryName}</p>
<c:if test="${not empty category.images}">
    <p>Image: <img src="${category.images}" alt="img" style="max-height:120px"/></p>
</c:if>
<p><a href="<c:url value='/admin/categories'/>">Back</a></p>
</body></html>