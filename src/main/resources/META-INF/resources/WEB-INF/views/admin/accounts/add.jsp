<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><meta charset="UTF-8"><title>Add/Edit User</title></head>
<body>
<h2>${user.id == null ? 'Add' : 'Edit'} User</h2>

<form method="post" action="<c:url value='/admin/users/saveOrUpdate'/>">
    <div>
        <label>ID</label><br/>
        <input type="text" name="id" value="${user.id}" readonly/>
    </div>
    <div>
        <label>Username</label><br/>
        <input type="text" name="username" value="${user.username}" required/>
    </div>
    <div>
        <label>Password</label><br/>
        <input type="text" name="password" value="${user.password}" required/>
    </div>
    <div>
        <label>Full name</label><br/>
        <input type="text" name="fullName" value="${user.fullName}"/>
    </div>
    <div>
        <label>Email</label><br/>
        <input type="email" name="email" value="${user.email}"/>
    </div>
    <div>
        <label>Active</label><br/>
        <!-- hidden gửi false nếu không tick -->
        <input type="hidden" name="active" value="false"/>
        <input type="checkbox" name="active" value="true" <c:if test="${user.active}">checked</c:if> />
    </div>

    <div style="margin-top:10px;">
        <button type="submit">Save</button>
        <a href="<c:url value='/admin/users'/>">List</a>
    </div>
</form>

</body>
</html>