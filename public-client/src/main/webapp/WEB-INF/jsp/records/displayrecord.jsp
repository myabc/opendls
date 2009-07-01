<%-- displayrecord.jsp --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cffn" uri="/WEB-INF/tlds/CustomFormat.tld"  %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="java.io.StringReader,
 org.xml.sax.InputSource,
 com.allaire.wddx.WddxDeserializer,
 java.util.*" %>



<c:set var="descriptionExists" value="false" scope="page" /> <%-- type="BOOLEAN" --%>

<c:set var="maxDescLen" value="1000" />


<script language="JavaScript">
<!--
// Peform a broad test for Internet Explorer 5.5;
var ie55 = /MSIE ((5\.[56789])|([6789]))/.test( navigator.userAgent ) &&
   navigator.platform == "Win32";


// This process can be replaced with Server Side functions in CF 5
var viewPg = "filemanager/download.cfm?id=";
var imgPg = "<cfoutput>#cgi.script_name#?fuseaction=records.imagedisplay&#request.URLToken#</cfoutput>&url=";

function writeRelFld(str) {
 if(isURL(str)) {
  document.write("<a href='"+str+"' target='_top'>"+str+"</a>")
 } else if (isUUID(str)) {
  document.write("<a href='"+viewPg+str+"'>View Record</a>")
 }
}
function isURL(s) {
 var reg = new RegExp("/(\w+)://([^/:]+)(:\d+)?/(.*)|/");
 return reg.test(s);
}
function isUUID(s) {
 var str = decodeURIComponent(str); //Decode it as a URL string
 var reg = new RegExp("\.{8}\x2D\.{4}\x2D\.{4}\x2D\.{16}");
 return reg.test(s);
}
function displayImage(url) {
 window.open(imgPg+url,'imgViewer','resizable=yes,scrollbars=yes');
}

function downloadItem(url,tt) {

 if(ie55) {
  var SP1_VER_CONST = "5.50.4522.1800";
  var SP2_VER_CONST = "5.51.4807.2300";
  var fullVersion = blankSpace.getComponentVersion("{89820200-ECBD-11CF-8B85-00AA005B4383}","componentid");


  if(fullVersion.indexOf(SP1_VER_CONST)!=-1) {
   var canNotDownload = true;

  } else {
   var canNotDownload = false;
  }

 } else {
  var canNotDownload = false;
 }

 if(canNotDownload) {
  var msg = "Internet Explorer 5.5 Service Pack 1 User: \n" +
    "-----------------------------------------\n\n" +
    "To download this file, please click View this File \n" +
    "and then right-click in your browser, click Save As..";
  alert(msg);
 } else {
  window.location = "filemanager/download.cfm?id="+url+"&as="+tt;
 }


}

//-->
</script>


<%--
<cfscript>
viewPg = "filemanager/download.cfm?id=";



/**
 * Returns TRUE if the string is a valid CF UUID.
 *
 * @param str 	 String to be checked.
 * @return Returns a boolean.
 * @author Jason Ellison (jason@daemon.com.au)
 * @version 1, October 5, 2001
 */
function isCFUUID(str) {
 return REFindNoCase("^[0-9A-F]{8}-[0-9A-F]{4}-[0-9A-F]{4}-[0-9A-F]{16}$", str);
}

/**
 * A quick way to test if a string is a URL
 *
 * @param stringToCheck 	 The string to check.
 * @return Returns a boolean.
 * @author Nathan Dintenfass (nathan@changemedia.com)
 * @version 1, November 22, 2001
 */
function isURL(stringToCheck){
  return REFindNoCase("^(((https?:|ftp:|gopher:)\/\/))[-[:alnum:]\?%,\.\/&##!@:=\+~_]+[A-Za-z0-9\/]$",stringToCheck);
}

</cfscript>
--%>

<div id="blankSpace" style="behavior:url(#default#clientCaps)"></div>

<table width="100%" cellpadding="4" cellspacing="0" border="0">
 <tr height="20">
  <td bgcolor="<spring:theme code="colors.controls2background"/>"
   class="displayOptions">&nbsp;<a href="javascript:history.back()"><img src="system/icons/navthrurecords_left.gif" width="15" height="13" border="0" alt="left"> Back</a></td>
 </tr>
</table>


<h1>${item.title}</h1>


<table>
<tr valign="top">
 <td rowspan="2"><img src="app_images/record_fileicon.gif"
  width="40" height="40" alt="Files Icon" /></td>
 <td class="recordDataGroup">Files</td></tr>
<tr>
 <td>

<table>
<tr>

<c:forEach var="file" items="${item.files}" varStatus="status">
 <%--- Establish file path ---%>
 <c:set var="thisFilePath" value="http://opendls.org/DATA/files" />
 <c:set var="thumbPath" value="http://opendls.org/DATA/thumbs" />
<td>

<table>
<tr>
 <td colspan="2" align="center"><a href="javascript:displayImage('${thisFilePath}/${file.fileName}')"><img src="${thumbPath}/${file.thumbFile}" alt="${file.fileName}" /></a></td></tr>
<tr>
 <td align="right" class="recordDataField">File size:</td>
 <td class="recordData">${cffn:formatFileSize(file.fileSize)}</td></tr>


 <%-- If it is a browser openable file --%>




 </td></tr>
</table>

</td>
</c:forEach>
</tr>
</table>

</td></tr>
</table>


<table>
<tr valign="top">
 <td rowspan="2"><img src="app_images/record_dataicon.gif"
  width="40" height="40" alt="Data Icon" /></td>
 <td class="recordDataGroup">Primary Metadata</td></tr>
<tr>
 <td>

<table>
<tr>
 <td align="right" class="recordDataField"><span title="A name given to the resource.">Title:</span></td>
 <td class="recordData">${item.title}</td>
 <td class="recordData"><%--<a href="default.cfm?fuseaction=records.searchresults&tt=#urlEncodedFormat(title)#">Search Title</a>--%></td></tr>
<tr>
 <td align="right" class="recordDataField"><span title="Any form of the title used as a substitute or alternative to the formal title of the resource.">Alternative Title:</span></td>
 <td class="recordDataItal">
 <c:choose>
  <c:when test="${not empty item.titleAlternative}">
  ${item.titleAlternative}
  </c:when>
  <c:otherwise>
  <span class="na">(none)</span>
  </c:otherwise>
 </c:choose>
 </td>
 <td class="recordData"></td></tr>
<tr>
 <td align="right" class="recordDataField"><span title="An entity primarily responsible for making the content of the resource.">Creator:</span></td>
 <td class="recordData">${item.creator}</td>
 <td class="recordData"></td></tr>
<c:if test="${not empty item.source}">
<tr>
 <td align="right" class="recordDataField"><span title="A reference to a resource from which the present resource is derived.">Source:</span></td>
 <td class="recordData">${item.source}</td></tr>
</c:if>
<tr>
 <td align="right" class="recordDataField"><span title="An entity responsible for making the resource available.">Publisher:</span></td>
 <td class="recordData">
 <c:choose>
  <c:when test="${not empty item.publisher}">
   ${item.publisher}
  </c:when>
  <c:otherwise>
   <span class="na">(none)</span>
  </c:otherwise>
 </c:choose>
 </td></tr>
<tr>
 <td align="right" class="recordDataField"><span title="An entity responsible for making contributions to the content of the resource.">Contributor:</span></td>
 <td class="recordData">
 <c:choose>
  <c:when test="${not empty item.contributorOrgCode}">

        </c:when>
  <c:otherwise>
   ${item.contributor}
  </c:otherwise>
 </c:choose>
 </td></tr>
<tr>
 <td align="right" class="recordDataField"><span title="A language of the intellectual content of the resource.">Language:</span></td>
 <td class="recordData">${item.language} - ${item.language.displayName}</td></tr>
<tr>
 <td align="right" class="recordDataField"><span title="Information about rights held in and over the resource.">Rights:</span></td>
 <td class="recordData">
 <c:choose>
  <c:when test="${not empty item.rights}">
   ${item.rights}
  </c:when>
  <c:otherwise>
   <span class="na">(public domain)</span>
  </c:otherwise>
 </c:choose>
 </td></tr>
<tr>
 <td align="right" class="recordDataField"><span title="A category of user for whom the resource is intended.">Audience:</span></td>
 <td class="recordData">
  <c:choose>
   <c:when test="${not empty item.audience}">
    {$item.audience}
   </c:when>
   <c:otherwise>
    <span class="na">(general)</span>
   </c:otherwise>
  </c:choose>
  </td></tr>
<tr valign="top">
 <td align="right" class="recordDataField"><span title="The topic of the content of the resource.">Subject:</span></td>
 <td class="recordData">
  <c:forEach var="i" items="${item.subject}" varStatus="status">
  ${i}<br />
  </c:forEach>
 </td></tr>
</table>

</td></tr>
</table>




<table>
<tr valign="top">
 <td rowspan="2"><img src="app_images/record_descicon.gif"
  width="40" height="40" alt="Description Icon" /></td>
 <td class="recordDataGroup">Description</td></tr>
<tr>
 <td>

<table>

<c:if test="${not empty item.descriptionTableOfContents}">
<tr>
 <td align="right" class="recordDataField">Table Of Contents:</td>
 <td class="recordData">${item.descriptionTableOfContents}
 <%--#htmlEditFormat(reReplace(mid(description_tableOfContents,1,1000),"<[^>]*>","","ALL"))#--%>
 </td></tr>
 <c:set var="descriptionExists" value="true" />
</c:if>

<c:if test="${not empty item.descriptionAbstract}">
<tr>
 <td align="right" class="recordDataField">Abstract:</td>
 <td class="recordData">${item.descriptionAbstract}

 <%--- Removed Description Limits, 10/20/2002 A Coles
 #htmlEditFormat(reReplace(mid(description_abstract,1,1000),"<[^>]*>","","ALL"))#--%>
 <%---<a href="#cgi.script_name#?fuseaction=records.viewdescription&#request.URLToken#&id=">(more...)</a>--%>
 </td></tr>
 <c:set var="descriptionExists" value="true" />
</c:if>

<c:if test="${not descriptionExists}">
<tr><td class="recordData">No description information exists for this record</td></tr>
</c:if>
</table>

</td></tr>
</table>




<table>
<tr valign="top">
 <td rowspan="2"><img src="app_images/record_dateicon.gif"
  width="40" height="40" alt="Date Icon" /></td>
 <td class="recordDataGroup">Date</td></tr>
<tr>
 <td>

<table cellspacing="1" cellpadding="2" border="0">
<c:if test="${not empty item.dateCreated}">
<tr>
 <td align="right" class="recordDataField">Created:</td>
 <td class="recordData"><fmt:formatDate value="${item.dateCreated}" type="date" dateStyle="long"/></td></tr>
</c:if>
<c:if test="${not empty item.dateValid}">
<tr>
 <td align="right" class="recordDataField">Valid:</td>
 <td class="recordData"><fmt:formatDate value="${item.dateValid}" type="date" dateStyle="long"/></td></tr>
</c:if>
<tr>
 <td align="right" class="recordDataField">Available:</td>
 <td class="recordData"><fmt:formatDate value="${item.dateAvailable}" type="date" dateStyle="long"/></td></tr>
<tr>
 <td align="right" class="recordDataField">Issued:</td>
 <td class="recordData"><fmt:formatDate value="${item.dateIssued}" type="date" dateStyle="long"/></td></tr>
<tr>
 <td align="right" class="recordDataField">Modified:</td>
 <td class="recordData"><fmt:formatDate value="${item.dateModified}" type="date" dateStyle="long"/></td></tr>
</table>

 </td></tr>
</table>



<table>
<tr valign="top">
 <td rowspan="2"><img src="app_images/record_relationicon.gif"
  width="40" height="40" alt="Relation Icon" /></td>
 <td class="recordDataGroup">Relation</td></tr>
<tr>
 <td>

<table>
<c:choose>
<c:when test="${not empty item.relations}">
<c:if test="${not empty item.relations.isVersionOf}">
<tr>
 <td align="right" class="recordDataField">Is Version Of:</td>
 <td class="recordData"><script language="JavaScript" type="text/javascript">writeRelFld("#relation_isVersionOf#")</script></td></tr>
</c:if>

<c:if test="${not empty item.relations.hasVersion}">
<tr>
 <td align="right" class="recordDataField">Has Version:</td>
 <td class="recordData"><script language="JavaScript" type="text/javascript">writeRelFld("#relation_hasVersion#")</script></td></tr>
</c:if>

<c:if test="${not empty item.relations.isReplacedBy}">
<tr>
 <td align="right" class="recordDataField">Is Replaced By:</td>
 <td class="recordData"><script language="JavaScript" type="text/javascript">writeRelFld("#relation_isReplacedBy#")</script></td></tr>
</c:if>

<c:if test="${not empty item.relations.replaces}">
<tr>
 <td align="right" class="recordDataField">Replaces:</td>
 <td class="recordData"><script language="JavaScript" type="text/javascript">writeRelFld("#relation_replaces#")</script></td></tr>
</c:if>

<c:if test="${not empty item.relations.isRequiredBy}">
<tr>
 <td align="right" class="recordDataField">Is Required By:</td>
 <td class="recordData"><script language="JavaScript" type="text/javascript">writeRelFld("#relation_isRequiredBy#")</script></td></tr>
</c:if>

<c:if test="${not empty item.relations.requires}">
<tr>
 <td align="right" class="recordDataField">Requires:</td>
 <td class="recordData"><script language="JavaScript" type="text/javascript">writeRelFld("#relation_requires#")</script></td></tr>
</c:if>

<c:if test="${not empty item.relations.isPartOf}">
<tr>
 <td align="right" class="recordDataField">Is Part Of:</td>
 <td class="recordData"><script language="JavaScript" type="text/javascript">writeRelFld("#relation_isPartOf#")</script></td></tr>
</c:if>

<c:if test="${not empty item.relations.hasPart}">
<tr>
 <td align="right" class="recordDataField">Has Part:</td>
 <td class="recordData"><script language="JavaScript" type="text/javascript">writeRelFld("#relation_hasPart#")</script></td></tr>
</c:if>

<c:if test="${not empty item.relations.isReferencedBy}">
<tr>
 <td align="right" class="recordDataField">Is Referenced By:</td>
 <td class="recordData"><script language="JavaScript" type="text/javascript">writeRelFld("#relation_isReferencedBy#")</script></td></tr>
</c:if>

<c:if test="${not empty item.relations.references}">
<tr>
 <td align="right" class="recordDataField">References:</td>
 <td class="recordData"><script language="JavaScript" type="text/javascript">writeRelFld("#relation_references#")</script></td></tr>
</c:if>

<c:if test="${not empty item.relations.isFormatOf}">
<tr>
 <td align="right" class="recordDataField">Is Format Of:</td>
 <td class="recordData"><script language="JavaScript" type="text/javascript">writeRelFld("#relation_isFormatOf#")</script></td></tr>
</c:if>

<c:if test="${not empty item.relations.hasFormat}">
<tr>
 <td align="right" class="recordDataField">Has Format:</td>
 <td class="recordData"><script language="JavaScript" type="text/javascript">writeRelFld("#relation_hasFormat#")</script></td></tr>
</c:if>
</c:when>
<c:otherwise>
<tr><td class="recordData">No relation information exists for this record</td></tr>
</c:otherwise>
</c:choose>

</table>

 </td></tr>
</table>




<table>
<tr valign="top">
 <td rowspan="2"><img src="app_images/record_covicon.gif"
  width="40" height="40" alt="Coverage Icon" /></td>
 <td class="recordDataGroup">Coverage</td></tr>
<tr>
 <td>

<c:choose>
<c:when test="${not empty item.coverage}">

<c:if test="${(not empty item.coverage.spatialminLat) ||
    (not empty item.coverage.spatialMinLong) ||
    (not empty item.coverage.spatialMaxLat) ||
    (not empty item.coverage.spatialMaxLong)}">

 <h5>Spatial</h5>
 <table>
 <tr>
  <td></td>
  <th class="recordDataField">Latitude</th>
  <th class="recordDataField">Longitude</th></tr>
 <tr>
  <td class="recordDataField">Min</td>
  <td class="recordData">${item.coverage.spatialMinLat}</td>
  <td class="recordData">${item.coverage.spatialMinLong}</td></tr>
 <tr>
  <td class="recordDataField">Max</td>
  <td class="recordData">${item.coverage.spatialMaxLat}</td>
  <td class="recordData">${item.coverage.spatialMaxLong}</td></tr>
 </table>


</c:if>

<c:if test="${not empty item.coverage.temporal}">
 <table cellspacing="1" cellpadding="2" border="0">
 <tr>
  <td align="right" class="recordDataField">Temporal:</td>
  <td class="recordData">${item.coverage.temporal}</td></tr>
 </table>
</c:if>

</c:when>
<c:otherwise>
<table>
<tr><td class="recordData">No coverage information exists for this record</td></tr>
</table>
</c:otherwise>
</c:choose>

 </td></tr>
</table>
