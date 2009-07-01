<%--- header.jsp --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
 <title>OpenDLS: <cfoutput>#request.library.name#</cfoutput></title>

 <script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/app_jscsslib/defaultlib.js"></script>

 <link rel="stylesheet" href="${pageContext.request.contextPath}/app_jscsslib/styles.css" type="text/css" />


 <%-- hack to get this working on pages with uris like help/**.html --%>
 <base href="${pageContext.request.contextPath}/" />

</head>
<body bgcolor="#<spring:theme code="colors.bodybackground"/>"
  text="#<spring:theme code="colors.body"/>"
  leftmargin="0" topmargin="0"
  marginwidth="0" marginheight="0">



<noscript>
<h1>The Digital Library System software Requires JavaScript</h1>
<p>Please upgrade your browser or enable JavaScript before proceeding.</p>
<hr />
</noscript>


<spring:theme code="htmlhead"/>

<table width="100%" border="0" cellpadding="2" cellspacing="0">
 <tr valign="top">
  <td class="tabs"><img src="${pageContext.request.contextPath}/app_images/spacer.gif" width="150" height="1" alt="" /></td>
  <td class="tabs" nowrap="nowrap"><a href="${pageContext.request.contextPath}/home.html"
   title="Start Page and Quick Keyword Search"
   onmouseover="displayStatusMsg('Home: Start Page and Quick Keyword Search');return document.returnValue"
   onmouseout="displayStatusMsg('');return document.returnValue">home</a></td>
  <td class="tabs"><img src="${pageContext.request.contextPath}/app_images/spacer.gif" width="10" height="1" alt="" /></td>
  <td class="tabs" nowrap="nowrap"><a href="search.html"
   title="Perform Field-specific Full Searches"
   onmouseover="displayStatusMsg('Advanced Search: Perform Field-specific Full Searches');return document.returnValue"
   onmouseout="displayStatusMsg('');return document.returnValue">advanced search</a></td>
  <td class="tabs" width="100%">&nbsp;</td>
  <td class="tabs" nowrap="nowrap"><a href="help/index.html"
   title="Information on Using the System and Contact Details"
   onmouseover="displayStatusMsg('Help: Information on Using the System and Contact Details');return document.returnValue"
   onmouseout="displayStatusMsg('');return document.returnValue">help</a></td>
  <td class="tabs"><img src="${pageContext.request.contextPath}/app_images/spacer.gif" width="10" height="1" alt="" /></td>
 </tr>
</table>
