<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><meta charset="UTF-8"><title>Video Detail</title></head>
<body>
<h2>Video Detail</h2>
<p><b>ID:</b> ${video.id}</p>
<p><b>Title:</b> ${video.title}</p>
<p><b>Description:</b> ${video.description}</p>
<p><b>URL:</b> <a href="${video.url}" target="_blank">${video.url}</a></p>
<p><b>Active:</b> <c:out value="${video.active}"/></p>

<p><a href="<c:url value='/admin/videos'/>">Back</a></p>
</body>
</html>