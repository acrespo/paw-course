<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<body>
 <c:forEach var="selectedUser" items="${users}">
        <c:out value="${selectedUser}"/>
    </c:forEach>
    </body>
    </html>