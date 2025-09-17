<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html><head><meta charset="UTF-8"><title>Add/Edit Category</title></head>
<body>
<h2>${category.id == null ? 'Add' : 'Edit'} Category</h2>
<form method="post" action="<c:url value='/admin/categories/saveOrUpdate'/>">
    <label>ID</label>
    <input type="text" name="id" value="${category.id}" readonly/><br/>
    <label>Name</label>
    <input type="text" name="categoryName" value="${category.categoryName}" required/><br/>
    <label>Images (URL)</label>
    <input type="text" name="images" value="${category.images}"/><br/>
    <button type="submit">Save</button>
    <a href="<c:url value='/admin/categories'/>">List</a>
</form>
</body></html>