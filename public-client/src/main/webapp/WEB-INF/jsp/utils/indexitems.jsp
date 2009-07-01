<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<P>
<H2>Compass Index</H2>
<P>
Use the Index button to index the database using Compass::Gps. The operation will
delete the current index and reindex the database based on the mappings and devices
defined in the Compass::Gps configuration context.
<FORM method="POST" action="/dls//utils/indexitems.html">
 <spring:bind path="command.doIndex">
  <INPUT type="hidden" name="doIndex" value="true" />
 </spring:bind>
    <INPUT type="submit" value="Index"/>
</FORM>
<c:if test="${! empty indexResults}">
 <P>Indexing took: <c:out value="${indexResults.indexTime}" />ms.
</c:if>
<P>
<BR>

</body>
</html>
