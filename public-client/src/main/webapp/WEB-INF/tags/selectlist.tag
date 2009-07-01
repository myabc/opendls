<%--SELF CONTAINEDcalled as customtag (using <cfmodule> in this application)Make Select List modulefor imagelibORIGINALLY:cf_makeselectlist copyright 1999 Aaron Henselladapted for use in imagelib by Alexander Colesattributes.multiple functionality removedattributes.class added (for style sheets)attributes.size no longer requiredattributes.includeblank removed--%>

<%@ tag body-content="scriptless" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<%@ attribute name="size" required="false"  %><%@ attribute name="styleClass" required="false" %>
<%@ attribute name="fieldName" required="true" %>
<%@ attribute name="checkFlag" required="false" %>
<%@ attribute name="valuesList" required="false" %>
<%@ attribute name="displayList" required="true" %>
<%@ attribute name="selectedValue" required="false" %>

<c:if test="${empty pageScope.size}">
	<c:set var="size" value="1" scope="page"/>
</c:if><%-- TODO: add in check that valueslist == displaylist --%><select name="${pageScope.fieldName}" 
	size="${pageScope.size}" class="${pageScope.styleClass}">
<c:set var="c" value="0"/>
<c:forEach var="i" items="${pageScope.valuesList}" varStatus="status">
	<option value="${i}" 
		<c:if test="${i == pageScope.selectedValue}">selected</c:if>
		>${i}</option>	<%-- TODO: displayList values are not working in this tag file yet --%>
	<c:set var="c" value="${c+1}"/>
</c:forEach></select>