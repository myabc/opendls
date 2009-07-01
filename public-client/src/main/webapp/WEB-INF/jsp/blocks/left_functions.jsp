<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="dls" %>

<tiles:importAttribute name="collections"/>

<dls:leftblock title="Collections">
<table>
<tr><td class="leftContent">
<strong><a href="${pageContext.request.contextPath}/home.html?collection_id=none">Digital Library System</strong></a>
</td></tr>
</table>
<%--
<table>
<tr><td class="leftContent">
<a href="javascript:dspCntToggle('libNavPortals')"
 title="Display Portal List"
 onmouseover="displayStatusMsg('Library: Portals');return document.returnValue"
 onmouseout="displayStatusMsg('');return document.returnValue">Portals</a>
</td></tr>
</table>

<div id="libNavPortals" style="display:none">
<table>
<cfoutput query="getPortals">
<tr>
<td><img src="app_images/bullet.gif" width="3" height="3" hspace="2" vspace="6" alt="*" /></td>
<td class="leftContent"><a href="${pageContext.request.contextPath}/#request.page.defaultPage#?library_id=#library_id#&#request.URLToken#"
   title="#libraryName#"
   onmouseover="displayStatusMsg('Library: #libraryName#');return document.returnValue"
   onmouseout="displayStatusMsg('');return document.returnValue">#libraryName#</a></td></tr>
</cfoutput>
</table>
</div>
--%>
<table>
<tr><td class="leftContent">
<a href="javascript:dspCntToggle('libNavCollections')"
 title="Display Collection List"
 onmouseover="displayStatusMsg('Library: Collections');return document.returnValue"
 onmouseout="displayStatusMsg('');return document.returnValue">Collections</a>
</td></tr>
</table>
<div id="libNavCollections" style="display:none">
<table>
<c:forEach var="collection" items="${collections}" varStatus="status">
<tr>
<td><img src="${pageContext.request.contextPath}/app_images/bullet.gif" width="3" height="3" hspace="2" vspace="6" alt="*" /></td>
<td class="leftContent"><a href="${pageContext.request.contextPath}/home.html?collection_id=${collection.id}"
   title="${collection.name}"
   onmouseover="displayStatusMsg('Library: ${collection.name}');return document.returnValue"
   onmouseout="displayStatusMsg('');return document.returnValue">${collection.name}</a></td></tr>
</c:forEach>
</table>
</div>
</dls:leftblock>

<br />

<table>
<tr valign="top">
 <td><img src="app_images/functions_addfavorite.gif"
 width="14" height="14" border="0"
 alt="Favorites Icon" /></td>
 <td class="leftFunctions"><a id="addAsFavorite" title=""
  href="javascript:addAsFavorite('#request.library.name#','#variables.thisLibURL#')"
  onmouseover="displayStatusMsg('Function: Add to My Favorites');return document.returnValue"
  onmouseout="displayStatusMsg('');return document.returnValue">Add #request.library.name# to my favorites</a></td></tr>
<tr valign="top">
 <td><img src="${pageContext.request.contextPath}/app_images/functions_makehomepage.gif"
 width="14" height="14" border="0"
 alt="Homepage Icon" /></td>
 <td class="leftFunctions"><a id="makeMyHomepage" title=""
  href="javascript:makeMyHomepage('#request.library.name#','#variables.thisLibURL#','makeMyHomepage')"
  onmouseover="displayStatusMsg('Function: Make My Homepage');return document.returnValue"
  onmouseout="displayStatusMsg('');return document.returnValue">Make #request.library.name# my homepage</a></td></tr>
</table>

<br />
