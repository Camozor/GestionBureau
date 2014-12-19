<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<j:if test="${admin == true}" >
    <form action="AdminLogout" method="POST">
        <input type ="submit" value="Log out!" />                
    </form>
</j:if>
