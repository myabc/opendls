<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="dls" %>

<tiles:importAttribute name="collections"/>

<form action="${pageContext.request.contextPath}/search.html"
 method="get"
 onsubmit="return checkQuickSearch(this)">
<%--
<input type="hidden" name="fuseaction" value="records.searchresults" />
<input type="hidden" name="searchType" value="quick" />
<input type="hidden" name="library_Id" value="<cfoutput>#request.library.id#</cfoutput>" /> <!--- Fixes 'back' button problem --->
--%>

<dls:leftblock title="Quick Search">

<table>
<tr><td colspan="2" class="leftContent">Enter Your Keywords: </td></tr>
<tr><td colspan="2"><input type="text" name="query" size="10" title="Enter your search criteria. The search engine will search record text fields for the keywords you enter" class="leftInput" /></td></tr>

<tr><td colspan="2" class="leftContent"><a href="/default.cfm?fuseaction=records.browseKeywords">Or Browse The Library</a></td></tr>
<tr><td colspan="2" class="leftContent">&nbsp;</td></tr>

<%-- REINSERT LOGIC FOR ALL LIBRARIES HERE --%>
<tr><td colspan="2">
 <select name="lb" size="1" class="leftDrop">
  <option value="" selected="selected">All Libraries</option>
 <c:forEach var="collection" items="${collections}" varStatus="status">
  <option value="${collection.id}">${collection.name}</option>
 </c:forEach>
 </select></td></tr>
<%--<cfelseif request.library.virtual>
<!--- Virtual Library --->

 <cfoutput>
 <input type="hidden" name="tp" value="#request.library.virtualType#">
 </cfoutput>

<cfelse>

 <cfoutput>
 <tr>
  <td><input type="radio" name="lb" id="libraryThis" value="#request.library.id#" checked="checked" /></td>
  <td  class="leftContent"><label title="Selecting this library will search only the resource records within this library" for="libraryThis">#request.library.name#</label></td></tr>
 <tr>
  <td><input type="radio" name="lb" id="libraryAll" value="" /></td>
  <td class="leftContent"><label title="Selecting the entire Digital Library System will search through this and any other available libraries in the Digital Library System" for="libraryAll">All <acronym title="Digital Library System">DLS</acronym> libraries</label></td></tr>
  </cfoutput>
--%>
<tr><td colspan="2"><input type="submit" value="Search" title="Search with the Keywords and search options selected above" class="leftSubmit" /></td></tr>
<tr><td colspan="2">
<cfoutput><a href="${pageContext.request.contextPath}/#request.page.defaultPage#?fuseaction=records.search&#request.URLToken#"
   title="Perform Field-specific Full Searches"
   onmouseover="displayStatusMsg('Advanced Search: Perform Field-specific Full Searches');return document.returnValue"
   onmouseout="displayStatusMsg('');return document.returnValue">Advanced Search</a></td></tr></cfoutput>
</table>
</dls:leftblock>

</form>
