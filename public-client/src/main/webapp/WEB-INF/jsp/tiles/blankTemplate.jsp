<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles" %>
<%@ page import="java.util.Iterator"%>

<!--
<tiles:getAsString name="title" ignore="true"/>
 -->


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
 <title>OpenDLS: Digital Library System</title>

 <script language="JavaScript" type="text/javascript" src="app_jscsslib/defaultlib.js"></script>

 <link rel="stylesheet" href="default.cfm?fuseaction=styles&library_id=none" type="text/css" />

</head>
<body>

<%-- *********** --%>
<%-- BodyContent --%>
<%-- *********** --%>
<tiles:insert name="content"/>
<%-- ************ --%>
<%-- /BodyContent --%>
<%-- ************ --%>

</body>
</html>
