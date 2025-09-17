<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><meta charset="UTF-8"><title>Add/Edit Video</title></head>
<body>
<h2>${video.id == null ? 'Add' : 'Edit'} Video</h2>

<form method="post" action="<c:url value='/admin/videos/saveOrUpdate'/>">
    <div>
        <label>ID</label><br/>
        <input type="text" name="id" value="${video.id}" readonly/>
    </div>
    <div>
        <label>Title</label><br/>
        <input type="text" name="title" value="${video.title}" required/>
    </div>
    <div>
        <label>Description</label><br/>
        <textarea name="description" rows="4" cols="60">${video.description}</textarea>
    </div>
    <div>
        <label>URL</label><br/>
        <input type="text" name="url" value="${video.url}"/>
    </div>
    <div>
        <label>Active</label><br/>
        <input type="hidden" name="active" value="false"/>
        <input type="checkbox" name="active" value="true" <c:if test="${video.active}">checked</c:if> />
    </div>

    <div style="margin-top:10px;">
        <button type="submit">Save</button>
        <a href="<c:url value='/admin/videos'/>">List</a>
    </div>
</form>

</body>
</html>