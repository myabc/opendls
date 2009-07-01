<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- Additional Styles For DLS Front Page -->
<style type="text/css">
a.portalLink:link,a.portalLink:active,a.portalLink:visited
 {font-size:15px;
 font-family:<spring:theme code="fonts.headers"/>;
 font-weight:bold;
 color:#003399;
 text-decoration:none;}

a.portalLink:hover
 {font-size:15px;
 font-family:<spring:theme code="fonts.headers"/>;
 font-weight:bold;
 color:#ffffff;
 background-color:#003399;
 text-decoration:none;}

.portalDesc
{margin:5px;
font-size:11px;
font-family:<spring:theme code="fonts.body"/>
}

a.collectionLink:link,a.collectionLink:active,a.collectionLink:visited
 {font-size:13px;
 font-family:<spring:theme code="fonts.headers"/>;
 font-weight:bold;
 color:#66CC00;
 text-decoration:none;}

a.collectionLink:hover
 {font-size:13px;
 font-family:<spring:theme code="fonts.headers"/>;
 font-weight:bold;
 color:#ffffff;
 background-color:#66CC00;
 text-decoration:none;}
</style>






<%-- Inner Layout Table --%>
<table>
<tr valign="top">
 <td width="220">

<%-- First Column --%>

<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
 codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0"
 WIDTH=260 HEIGHT=300>
 <PARAM NAME=movie VALUE="${pageContext.request.contextPath}/lib_assets/_dls/dlsillus.swf"> <PARAM NAME=quality VALUE=high> <PARAM NAME=bgcolor VALUE=#FFFFFF> <EMBED src="${pageContext.request.contextPath}/lib_assets/_dls/dlsillus.swf" quality=high bgcolor=#FFFFFF  WIDTH=260 HEIGHT=300 TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"></EMBED>
</OBJECT>



 </td>
 <td><img src="${pageContext.request.contextPath}/lib_assets/_dls/greycurve.gif" width="20" height="300" border="0" alt=" " /></td>
 <td>

<%-- Second Column --%>

<%-- Virtual/Portal Libraries --%>

<p class="bodyText"><strong>Welcome</strong> to this installation of OpenDLS,
    an online digital media library.
    You may search all the images, or you may search by individual collections,
    which are listed underneath.
    We plan to add additional media collections to the system in the future.</p>

<%-- Physical Libraries --%>

<div>

<table width="100%" cellspacing="0" cellpadding="0" border="0">
<tr>
<td colspan="2" align="right" style="background-image:url('${pageContext.request.contextPath}/lib_assets/_dls/collectiontitlebk.gif')"><img src="${pageContext.request.contextPath}/lib_assets/_dls/collectiontitle.gif" width="100" height="20" border="0" alt="Collections" /></td>
</tr>
<c:forEach var="collection" items="${collections}" varStatus="status">
<tr valign="top"><td><a href="${pageContext.request.contextPath}/home.html?collection_id=${collection.id}"><img src="${pageContext.request.contextPath}/lib_assets/_dls/collectionicon.gif" width="32" height="32" border="0" alt="Collection Icon" /></a></td>
<td><a href="${pageContext.request.contextPath}/home.html?collection_id=${collection.id}" class="collectionLink">${collection.name}</a></li>
</td></tr>
</c:forEach>
</table>

 </div>

</div>

<hr noshade="noshade" style="color:#cccccc;height:2px" />

<div>
<a href="http://www.firstgov.gov/"><img src="${pageContext.request.contextPath}/lib_assets/_dls/firstgov.gif"
 width="127" height="38" border="0"
 alt="First Gov - Your First Click to the U.S. Government" /></a>
</div>

 </td></tr>
</table>
