<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page import="java.util.Iterator"%>

<!--
<tiles:getAsString name="title" ignore="true"/>
 -->

<%---
*************************
*                       *
*  LAYOUT FOR IMAGELIB  *
*                       *
*************************
--%>

<%-- ****** --%>
<%-- Header --%>
<%-- ****** --%>
<tiles:insertAttribute name="header"/>

<table width="100%" cellspacing="0" cellpadding="0" border="0">
<tr valign="top">
<td width="5" bgcolor="#<spring:theme code="colors.leftareabackground"/>"><img src="app_images/spacer.gif" width="5" height="1" border="0" alt=""></td>
<td width="140" bgcolor="#<spring:theme code="colors.leftareabackground"/>"><img src="app_images/spacer.gif" width="140" height="1" border="0" alt=""><br /><br />

<%-- ********* --%>
<%-- LeftBlock --%>
<%-- ********* --%>
<tiles:useAttribute id="blockList" name="contentBlocks" classname="java.util.List"/>

<%
 //Iterator i = blockList.iterator();
 //while ( i.hasNext() )
 //{
 //	String name = (String) i.next();
%>
 <!-- >tiles:insert name="<%--=name%>" flush="true" --/>
 <br />
<%
 //} // end loop
%>
<tiles:insertAttribute name="functionsBlock" />

<%-- ********** --%>
<%-- /LeftBlock --%>
<%-- ********** --%>

</td>
<td width="5" bgcolor="#<spring:theme code="colors.leftareabackground"/>"><img src="app_images/spacer.gif" width="5" height="1" border="0" alt=""></td>
<td width="1" bgcolor="#<spring:theme code="colors.tabsbackground"/>"><img src="app_images/spacer.gif" width="1" height="1" border="0" alt=""></td>
<td width="9" bgcolor="#<spring:theme code="colors.contentbackground"/>"><img src="app_images/spacer.gif" width="9" height="1" border="0" alt=""></td>
<td bgcolor="#<spring:theme code="colors.contentbackground"/>">

<%-- *********** --%>
<%-- BodyContent --%>
<%-- *********** --%>
<tiles:insertAttribute name="content"/>
<%-- ************ --%>
<%-- /BodyContent --%>
<%-- ************ --%>

</td>
<td width="10" bgcolor="#<spring:theme code="colors.contentbackground"/>"><img src="app_images/spacer.gif" width="10" height="1" border="0" alt=""></td>
</tr>
</table>

<tiles:insertAttribute name="footer"/>
