<%--

<%@ tag body-content="scriptless" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<%@ attribute name="size" required="false"  %>
<%@ attribute name="fieldName" required="true" %>
<%@ attribute name="checkFlag" required="false" %>
<%@ attribute name="valuesList" required="false" %>
<%@ attribute name="displayList" required="true" %>
<%@ attribute name="selectedValue" required="false" %>

<c:if test="${empty pageScope.size}">
	<c:set var="size" value="1" scope="page"/>
</c:if>
	size="${pageScope.size}" class="${pageScope.styleClass}">
<c:set var="c" value="0"/>
<c:forEach var="i" items="${pageScope.valuesList}" varStatus="status">
	<option value="${i}" 
		<c:if test="${i == pageScope.selectedValue}">selected</c:if>
		>${i}</option>
	<c:set var="c" value="${c+1}"/>
</c:forEach>